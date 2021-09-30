package backend.Shop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order {

    private String tittle;
    private Double date;
    private Double price;
    private String customersName;

    @Id
    @GeneratedValue
    private Long id;

    //TODO
    // Отношение к базе клиентов.
    //    @ManyToOne


}
