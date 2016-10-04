package calculator;

import java.util.ArrayList;
import java.util.List;

import calculator.models.Todo;

public class todoBuilder {
	List<Todo> todos;
	
	public todoBuilder(){
		this.todos = new ArrayList<Todo>();
	}
	
	public todoBuilder AddTodo(){
		this.todos.add(new Todo());
		return this;
	}
	
	public List<Todo> Build(){
		return this.todos;
	}
}
