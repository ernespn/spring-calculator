package nestosoft.todo;

import java.util.ArrayList;
import java.util.List;

import nestosoft.todo.models.Todo;

public class todoBuilder {
	List<Todo> todos;
	
	public todoBuilder(){
		this.todos = new ArrayList<Todo>();
	}
	
	public todoBuilder AddTodo(){
		this.todos.add(new Todo());
		return this;
	}
	
	public List<Todo> GetTodoList(){
		return this.todos;
	}
	
	public Todo GetFirstTodo(){
		return this.todos.get(0);
	}

	public todoBuilder AddTodoWithId(String id) {
		Todo todo = new Todo();
		todo.id = id;
		todo.what = "what_"+id;
		this.todos.add(todo);
		return this;
	}
}
