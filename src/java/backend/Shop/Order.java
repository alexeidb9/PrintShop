package backend.Shop;

import backend.BaseModel;

import javax.persistence.Entity;

@Entity
public class Order extends BaseModel {

    private String tittle;
    private Double date;
    private Double price;
    private String customersName;

    //TODO
    // Отношение к базе клиентов.
    //    @ManyToOne


}
