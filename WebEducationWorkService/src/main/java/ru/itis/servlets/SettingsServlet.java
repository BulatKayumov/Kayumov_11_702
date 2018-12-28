package ru.itis.servlets;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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

@WebServlet("/showSettings")
public class SettingsServlet extends HttpServlet {

    ProductService productService;
    UsersService usersService;
    CartService cartService;
    OrderService orderService;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        List<Product> products = cartService.getAllByUserId(user.getId());

        PrintWriter writer = resp.getWriter();

        String result = new Gson().toJson(products);
        resp.setContentType("application/json; charset=UTF-8");
        writer.print(result);

        //Long productId = Long.valueOf(req.getParameter("productId"));
        //String theme = String.valueOf(req.getParameter("theme"));
        //String comment = String.valueOf(req.getParameter("comment"));
        //Long period_of_execution = Long.valueOf(req.getParameter("period_of_execution"));
        //Long min_pages_count = Long.valueOf(req.getParameter("min_pages_count"));
        //Long max_pages_count = Long.valueOf(req.getParameter("max_pages_count"));
        //Long cost = (max_pages_count + min_pages_count) / 2 * productService.find(productId).getPageCost();

        //orderService.add(user.getId(), productId, theme, comment, period_of_execution, min_pages_count, max_pages_count, cost);
    }
}
