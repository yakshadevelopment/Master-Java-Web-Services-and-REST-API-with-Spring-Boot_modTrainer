package yaksha.rest_ws.mod_trainer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Trainer {
	private Integer id;
	@Size(min=2, message="Name should be atleast two chars")
	private String name;
	@NotNull
	private String subject;
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trainer(Integer id, @Size(min = 2, message = "Name should be atleast two chars") String name,
			@NotNull String subject) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
