package calculator.models;

import org.springframework.data.annotation.Id;

public class Todo {
	
	@Id
	public String id;
	
	public String what;
	
}
