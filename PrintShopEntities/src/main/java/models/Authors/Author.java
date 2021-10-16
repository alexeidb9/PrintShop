package models.Authors;


import com.fasterxml.jackson.annotation.JsonIgnore;
import models.BaseModel;
import models.Prints.Print;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "Authors")
public class Author extends BaseModel {

    private String name;
    private String lastName;

    @Lob
    private byte[] image;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Print> prints;


}







