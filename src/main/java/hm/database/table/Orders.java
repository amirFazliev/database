package hm.database.table;

import java.util.Objects;

public class Orders {
    private int id;

    private String date;

    private int customers_id;

    private String product_name;

    private int amount;

    public Orders(int id, String date, int customers_id, String product_name, int amount) {
        this.id = id;
        this.date = date;
        this.customers_id = customers_id;
        this.product_name = product_name;
        this.amount = amount;
    }

    public Orders() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomers_id() {
        return customers_id;
    }

    public void setCustomers_id(int customers_id) {
        this.customers_id = customers_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id && customers_id == orders.customers_id && amount == orders.amount && Objects.equals(date, orders.date) && Objects.equals(product_name, orders.product_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, customers_id, product_name, amount);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", customers_id=" + customers_id +
                ", product_name='" + product_name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
