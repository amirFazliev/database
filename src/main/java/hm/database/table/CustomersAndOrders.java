package hm.database.table;

import java.util.Objects;

public class CustomersAndOrders {

    private Customers customers;
    private Orders orders;

    public CustomersAndOrders(Customers customers, Orders orders) {
        this.customers = customers;
        this.orders = orders;
    }

    public CustomersAndOrders() {
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersAndOrders customersAndOrders = (CustomersAndOrders) o;
        return Objects.equals(customers, customersAndOrders.customers) && Objects.equals(orders, customersAndOrders.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customers, orders);
    }

    @Override
    public String toString() {
        return "CustomersAndOrders{" +
                "customers=" + customers +
                ", orders=" + orders +
                '}';
    }
}
