package hm.database.domain;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private int age;
    private String phoneNumber;
}
