package fr.afpa.pompey.cda.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name= "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idperson")
    private int id;

    //@Column(name="firstname")
    private String firstname;

    //@Column(name="lastname")
    private String lastname;

}
