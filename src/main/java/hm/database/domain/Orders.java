package hm.database.domain;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    private String productName;
    private int amount;

    public void setCustomerId(int customerId) {
        this.customer = new Customers();
        this.customer.setId(customerId);
    }

    public int getCustomerId() {
        return this.customer.getId();
    }
}
