package rober.wildfly.echos.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the echos database table.
 * 
 */
@Entity
@Table(name = "echos")
@NamedQueries({ @NamedQuery(name = "Echo.findAll", query = "SELECT e FROM Echo e"),
		@NamedQuery(name = "Echo.countAll", query = "select count(e) from Echo e"),
		@NamedQuery(name = "Echo.findAllByName", query="select e from Echo e where e.message =:message")

})
public class Echo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String message;

	public Echo() {
	}

	public Echo(Integer id, String message) {

		this.id = id;
		this.message = message;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}