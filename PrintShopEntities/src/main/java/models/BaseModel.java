package models;


import javax.persistence.*;

@Entity
@MappedSuperclass
public class BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	public Long getId() {
		return id;
	}


	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
			return false;
		}

		BaseModel that = (BaseModel) obj;

		return this.id.equals(that.getId());
	}


	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}
}

