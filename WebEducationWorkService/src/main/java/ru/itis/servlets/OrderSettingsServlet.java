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

@WebServlet("/settings")
public class OrderSettingsServlet extends HttpServlet {

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
        req.setAttribute("user", user.getName());

        req.getRequestDispatcher("ftl/orderSettings.ftl").forward(req, resp);
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
        Long productId = Long.parseLong(req.getParameter("productId"));
        OrderForm form = OrderForm.builder()
                .userId(user.getId())
                .productId(productId)
                .name(productService.find(productId).getName())
                .photo(productService.find(productId).getPhoto())
                .theme(req.getParameter("theme"))
                .comment(req.getParameter("comment"))
                .period_of_execution(Integer.parseInt(req.getParameter("period_of_execution")))
                .min_pages_count(Integer.parseInt(req.getParameter("min_pages_count")))
                .max_pages_count(Integer.parseInt(req.getParameter("max_pages_count")))
                .build();
        int cost = (form.getMax_pages_count() + form.getMin_pages_count()) / 2 * productService.find(form.getProductId()).getPageCost();
        if(form.getPeriod_of_execution() < 30) {
            cost *= (40 - form.getPeriod_of_execution()) / 10;
        }
        form.setCost(cost);
        orderService.add(form);
    }
}
