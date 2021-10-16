package models.Prints;

import models.Authors.Author;
import main.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Comparator;

@Entity(name = "prints")
@Data
@NoArgsConstructor
public class Print extends BaseModel {

    // Is it the right placement of Comparator?

    public static final Comparator<Print> BY_WEIGHT
            = new Comparator<Print>()
    {
        public int compare(final Print p1, final Print p2)
        {
            return Integer.compare(p1.getWeight(), p2.getWeight());
        }
    };


    private String dimension;
    private int weight;
    private String url;
    private String title;
    private String paperType;
    private double priceTag;
    private boolean frame;

    @Lob
    private byte[] image;


    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;





}
