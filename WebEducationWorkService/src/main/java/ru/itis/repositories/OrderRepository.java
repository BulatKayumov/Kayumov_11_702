package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Order;
import ru.itis.models.Product;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderRepository {

    private JdbcTemplate jdbcTemplate;

    public OrderRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String SQL_INSERT_ORDER =
            "INSERT INTO order_work (user_id, work_id, name, photo, theme, comment, period_of_execution, min_pages_count, max_pages_count, cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_GET_ALL =
            "SELECT * FROM order_work JOIN work on order_work.work_id = work.id WHERE user_id = ?";


    private RowMapper<Order> rowMapper = (resultSet, i) -> Order.builder()
            .id(resultSet.getLong("id"))
            .userId(resultSet.getLong("user_id"))
            .productId(resultSet.getLong("work_id"))
            .theme(resultSet.getString("theme"))
            .comment(resultSet.getString("comment"))
            .period_of_execution(resultSet.getInt("period_of_execution"))
            .min_pages_count(resultSet.getInt("min_pages_count"))
            .max_pages_count(resultSet.getInt("max_pages_count"))
            .cost(resultSet.getInt("cost"))
            .build();

    public void add(Long userId, Long productId, String name, String photo, String theme, String comment, int period_of_execution, int min_pages_count, int max_pages_count, int cost){
        jdbcTemplate.update(SQL_INSERT_ORDER, userId, productId, name, photo, theme, comment, period_of_execution, min_pages_count, max_pages_count, cost);

    }

    public List<Order> getAllByUserId(Long userId) {
        return jdbcTemplate.query(SQL_GET_ALL, rowMapper, userId);
    }


}