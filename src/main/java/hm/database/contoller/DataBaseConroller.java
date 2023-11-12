package hm.database.contoller;

import hm.database.domain.Customers;
import hm.database.domain.Orders;
import hm.database.repository.DataBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/")

public class DataBaseConroller {

    @Autowired
    private final DataBaseRepository dataBaseRepository;

    public DataBaseConroller(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    @PostMapping("/create-customers")
    public void createCustomers(@RequestBody Customers customers) {
        dataBaseRepository.createCustomers(customers);
    }

    @PostMapping("/create-orders")
    public void createOrders(@RequestBody Orders orders) {
        dataBaseRepository.createOrders(orders);
    }

    @GetMapping("/products/fetch-product")
    public List<Orders> getProductName(@RequestParam("name") String name) throws SQLException {
        return dataBaseRepository.getProductName(name);
    }

    @GetMapping("/allCustomers")
    public List<Customers> allCustomers() {
        return dataBaseRepository.allCustomers();
    }
}
