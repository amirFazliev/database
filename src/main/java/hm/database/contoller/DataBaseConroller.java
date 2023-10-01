package hm.database.contoller;

import hm.database.repository.DataBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class DataBaseConroller {

    @Autowired
    private final DataBaseRepository dataBaseRepository;

    public DataBaseConroller(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    @GetMapping("/products/fetch-product")
    public List<Map<String, Object>> getProductName(@RequestParam("name") String name) throws SQLException {
        return dataBaseRepository.getProductName(name);
    }
}
