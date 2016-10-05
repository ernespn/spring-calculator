package calculator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.TestConfiguration;

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

	public todoBuilder AddTodoWithId(String id) {
		Todo todo = new Todo();
		todo.id = id;
		todo.what = "what_"+id;
		this.todos.add(todo);
		return this;
	}
}
