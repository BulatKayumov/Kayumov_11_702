package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.forms.OrderForm;
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

@WebServlet("/allorders")
public class AllOrdersServlet extends HttpServlet {

    ProductService productService;
    UsersService usersService;
    CartService cartService;
    OrderService orderService;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    @SneakyThrows
    public void init() throws ServletException {
        Class.forName("org.postgresql.Driver");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/educationWorkService");
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        CartRepository cartRepository = new CartRepository(dataSource);
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        ProductRepository productRepository = new ProductRepository(dataSource);
        OrderRepository orderRepository = new OrderRepository(dataSource);
        productService = new ProductService(productRepository, authRepository);
        usersService = new UsersServiceImpl(usersRepository, authRepository);
        cartService = new CartService(cartRepository, authRepository);
        orderService = new OrderService(orderRepository, authRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

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
        req.setAttribute("service", productService);
        req.setAttribute("user", user.getName());

        req.getRequestDispatcher("ftl/showOrders.ftl").forward(req, resp);
    }
}