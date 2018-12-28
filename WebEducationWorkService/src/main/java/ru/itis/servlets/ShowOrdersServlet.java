package ru.itis.servlets;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Order;
import ru.itis.models.Product;
import ru.itis.models.User;
import ru.itis.repositories.*;
import ru.itis.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showorders")
public class ShowOrdersServlet extends HttpServlet {

    ProductService productService;
    OrderService orderService;
    UsersService usersService;

    @Override
    @SneakyThrows
    public void init() throws ServletException {
        Class.forName("org.postgresql.Driver");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/educationWorkService");
        ProductRepository productRepository = new ProductRepository(dataSource);
        OrderRepository orderRepository = new OrderRepository(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        productService = new ProductService(productRepository, authRepository);
        orderService = new OrderService(orderRepository, authRepository);
        usersService = new UsersServiceImpl(usersRepository, authRepository);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            cookies = new Cookie[0];
        }

        User user = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("auth")) {
                if (usersService.isExistByCookie(cookie.getValue())) {
                    user = usersService.getUserByCookie(cookie.getValue());
                    break;
                }
            }
        }
        List<Order> orders = orderService.getAllByUserId(user.getId());


        PrintWriter writer = response.getWriter();

        String result = new Gson().toJson(orders);
        response.setContentType("application/json; charset=UTF-8");
        writer.print(result);

    }

}