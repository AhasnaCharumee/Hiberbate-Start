package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity//map to table
@Table(name = "customer_table")
public class Customer {
    @Id//primary key
    private int id;
    private String name;
    private String email;
    private String contact;


}
