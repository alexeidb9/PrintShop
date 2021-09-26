package backend.Prints;

import backend.Authors.Author;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Comparator;

@Entity
@Data
@NoArgsConstructor
public abstract class Print {

    @Id
    @GeneratedValue
    private Long id;


    private String dimension;
    private Double weight;
    private String name;
    private String description;
    private String color;
    private String paperType;
    private double price;
    private boolean frame;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
    private Author author;

    public static final Comparator<Print> BY_WEIGHT = Comparator.comparing(Print::getWeight);







}
