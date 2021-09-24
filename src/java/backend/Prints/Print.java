package backend.Prints;

import backend.Authors.Author;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public abstract class Print {


    private String dimension;
    private String name;
    private String description;
    private String color;
    private String paper;
    private double price;

    //frame
    //shape

    @Id
    @GeneratedValue
    private Long id;





}
