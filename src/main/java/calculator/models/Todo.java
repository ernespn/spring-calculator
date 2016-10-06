package calculator.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="todos")
public class Todo {
	
	@Id
	public String id;
	
	public String what;
	
}
