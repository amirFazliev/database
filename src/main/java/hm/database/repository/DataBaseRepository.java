package hm.database.repository;

import hm.database.table.Customers;
import hm.database.table.CustomersAndOrders;
import hm.database.table.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.stream.Collectors;

@Repository
public class DataBaseRepository {


    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DataBaseRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private final String sqlQuery = read("schema.sql");

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
        var result = namedParameterJdbcTemplate.queryForObject("select product_name from homework.ORDERS join homework.CUSTOMERS C on C.id = ORDERS.customer_id where C.name = :name order by C.name",
                map,
                (ResultSet rs, int rowNum) -> {
//            var customers = new Customers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
//            var orders = new Orders(rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10));
//            return new CustomersAndOrders(customers, orders);

                    String product = rs.getString(9);
                    return product;
                });

        System.out.println(result);
        return result;
    }
}
