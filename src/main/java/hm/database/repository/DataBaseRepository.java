package hm.database.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;

@Repository
public class DataBaseRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DataBaseRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) throws SQLException {
        MapSqlParameterSource map = new MapSqlParameterSource("name", name);
        var result = namedParameterJdbcTemplate.query("select product_name from homework.ORDERS join homework.CUSTOMERS on homework.CUSTOMERS.id = homework.ORDERS.customer_id where homework.CUSTOMERS.name = :name;",
                map,
                this::productNameMapRow);

        if (result.isEmpty()) {
            return "Заказ не найден";
        } else {
            return result.get(0);
        }
    }

    private String productNameMapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString(1);
    }
}
