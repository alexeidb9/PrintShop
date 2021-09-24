package backend.Authors;

import backend.Prints.Print;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "Author")
@Data
public class Author {


    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String lastName;


    @OneToMany(mappedBy = "Author")
    private List<Print> prints;


}
