package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Auth;
import ru.itis.models.Product;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductRepository {

    private JdbcTemplate jdbcTemplate;

    public ProductRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String SQL_READ_BY_ID =
            "SELECT name from work where id = ?";

    private static final String SQL_SELECT_COST_BY_ID =
            "SELECT cost from work where id = ?";

    private static final String SQL_SELECT_ALL_PRODUCTS =
            "SELECT * from work";

    private static final String SQL_SEARCH =
            "SELECT * from work where work.name ilike ?";

    private RowMapper<Product> productRowMapper = (resultSet, i) -> Product.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .pageCost(resultSet.getInt("page_cost"))
            .photo(resultSet.getString("photo"))
            .build();

    private RowMapper<String> rowMapper = (rs, rowNum) -> rs.getString("name");

    public String get(Long productId) {
        return jdbcTemplate.queryForObject(SQL_READ_BY_ID, rowMapper, productId);
    }

    public Product find(Long productId) {
        return jdbcTemplate.queryForObject(SQL_SELECT_COST_BY_ID, productRowMapper, productId);
    }

    public List<Product> findAllByNameSearch(String name) {
        return jdbcTemplate.query(SQL_SEARCH, productRowMapper, "%" + name + "%");
    }
}
