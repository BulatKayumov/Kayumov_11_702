package ru.itis.servlets;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Product;
import ru.itis.models.User;
import ru.itis.repositories.*;
import ru.itis.services.CartService;
import ru.itis.services.ProductService;
import ru.itis.services.UsersService;
import ru.itis.services.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    ProductService productService;
    CartService cartService;
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
        CartRepository cartRepository = new CartRepository(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        productService = new ProductService(productRepository, authRepository);
        cartService = new CartService(cartRepository, authRepository);
        usersService = new UsersServiceImpl(usersRepository, authRepository);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId = Long.valueOf(request.getParameter("productId"));

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

        if(productId != 0) {
            cartService.add(user.getId(), productId);
        }

        List<Product> products = cartService.getAllWithCountByUserId(user.getId());


        PrintWriter writer = response.getWriter();

        String result = new Gson().toJson(products);
        response.setContentType("application/json; charset=UTF-8");
        writer.print(result);

    }


}
