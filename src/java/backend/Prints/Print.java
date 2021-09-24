package backend.Prints;

import backend.Authors.Author;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public abstract class Print {

    @Id
    @GeneratedValue
    private Long id;


    private String dimension;
    private String name;
    private String description;
    private String color;
    private String paperType;
    private double price;
    private boolean frame;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
    private Author author;





}
