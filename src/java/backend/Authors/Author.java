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

@Entity(name = "Author")
@Data
@NoArgsConstructor
public class Author {

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
