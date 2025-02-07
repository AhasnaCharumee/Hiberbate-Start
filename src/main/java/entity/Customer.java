package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity//map to table
@Table(name = "customer_table")
public class Customer {
    @Id//primary key
   @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
  //  @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY) //manual
//    @GeneratedValue(strategy = GenerationType.UUID)
   // @Column(name = "Hello_id")//when you want change column name
   // @Column(name = "id",nullable = false)//cannot null
    //nulable true = can null
    //@Transient//for sensitive data non perasist

    private int id;
    private String name;
    private String email;
    private String contact;


}
