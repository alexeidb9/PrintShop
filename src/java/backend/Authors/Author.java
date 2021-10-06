package backend.Authors;

import backend.Prints.Print;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "Authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    // TODO set up database manually

    private String name;
    private String lastName;


    @Id
    @GeneratedValue
    private Long id;


    @OneToMany(mappedBy = "author")
    @JsonIgnore
    // Isn't HashMap better in that case?
    private List<Print> prints;



}
