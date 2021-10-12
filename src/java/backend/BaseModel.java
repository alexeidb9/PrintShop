package backend;

import javax.persistence.*;

@Entity
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    public long getID() {
        return ID;
    }
}
