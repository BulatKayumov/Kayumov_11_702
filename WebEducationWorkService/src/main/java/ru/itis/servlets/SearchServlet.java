package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Product;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.AuthRepositoryImpl;
import ru.itis.repositories.CartRepository;
import ru.itis.repositories.ProductRepository;
import ru.itis.services.CartService;
import ru.itis.services.ProductService;
import ru.itis.services.SearchService;
import ru.itis.services.SearchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private SearchService service;

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
        ProductRepository productRepository = new ProductRepository(dataSource);
        CartRepository cartRepository = new CartRepository(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        this.service = new SearchServiceImpl(productRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String query = req.getParameter("q");
        if (query != null) {
            List<Product> result = service.search(query);

            String resultJson = mapper.writeValueAsString(result);
            resp.setStatus(200);
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(resultJson);
        } else {
            req.getRequestDispatcher("ftl/order.ftl").forward(req, resp);
        }
    }
}
