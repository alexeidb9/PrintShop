package backend.Authors;

import backend.BaseModel;
import backend.Prints.Print;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "AUTHORS")
@Data
@NoArgsConstructor
public class Author extends BaseModel {

    @Column
    private String name;
    private String lastName;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Print> prints;

}
