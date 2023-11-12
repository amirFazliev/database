package hm.database.repository;

import hm.database.domain.Customers;
import hm.database.domain.Orders;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataBaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createCustomers (Customers customers) {
        entityManager.persist(customers);
    }

    @Transactional
    public void createOrders (Orders orders) {
        Customers existingCustomer = entityManager.find(Customers.class, orders.getCustomerId());
        if (existingCustomer != null) {
            orders.setCustomer(existingCustomer);
            entityManager.persist(orders);
        } else {
            System.out.println("error - no id");
        }

    }

    @Transactional
    public List<Orders> getProductName(String name) {
        var query = entityManager.createQuery(
                "SELECT o " +
                        "FROM Orders o " +
                        "JOIN o.customer c " +
                        "WHERE c.name = :name", Orders.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Transactional
    public List<Customers> allCustomers() {
        var query = entityManager.createQuery(
                "SELECT customers from Customers customers", Customers.class);
        return query.getResultList();
    }
}
