package backend.Authors;

import backend.Prints.Print;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "Author")
@Data
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String lastName;


    @OneToMany(mappedBy = "Author")
    private List<Print> prints;


    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
