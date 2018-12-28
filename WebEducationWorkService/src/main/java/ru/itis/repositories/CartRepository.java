package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Product;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartRepository {

    private JdbcTemplate jdbcTemplate;

    public CartRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String SQL_INSERT_PRODUCT =
            "INSERT INTO cart (user_id, work_id) VALUES (?, ?)";

    private static final String SQL_INSERT_ORDER =
            "INSERT INTO order_work (user_id, work_id, theme, comment, period_of_execution, min_pages_count, max_pages_count, cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_PRODUCT =
            "DELETE FROM cart where user_id = ? and id = ?";

    private static final String SQL_GET_ALL =
            "SELECT * FROM cart JOIN work on cart.work_id = work.id WHERE user_id = ?";

    private RowMapper<Product> rowMapper = (rs, rowNum) -> Product.builder()
            .id(rs.getLong("id"))
            .name(rs.getString("name"))
            .photo(rs.getString("photo"))
            .pageCost(rs.getInt("page_cost"))
            .build();

    public void add(Long userId, Long productId){
        jdbcTemplate.update(SQL_INSERT_PRODUCT, userId, productId);

    }

    public void delete(Long userId, Long productId){
        jdbcTemplate.update(SQL_DELETE_PRODUCT, userId, productId);
    }

    public List<Product> getAllByUserId(Long userId) {
        return jdbcTemplate.query(SQL_GET_ALL, rowMapper, userId);
    }


}
