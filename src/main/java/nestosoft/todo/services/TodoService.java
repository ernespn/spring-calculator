package nestosoft.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nestosoft.todo.models.Todo;
import nestosoft.todo.repositories.ITodoRepository;

@Service
public class TodoService {

	private final ITodoRepository repository;

	@Autowired
	public TodoService(ITodoRepository todoRepository){
		this.repository = todoRepository;
	}

	public List<Todo> GetAllTodos() {
		List<Todo> all = this.repository.findAll();
		return all;
	}

	public Todo GetById(String string) {
		Todo todo = this.repository.findById(string);
		return todo;
	}

	public void SaveTodo(Todo newTodo) {
		this.repository.save(newTodo);
	}

	public void DeleteTodo(String id) {
		Todo todo = this.GetById(id);
		this.repository.delete(todo);
	}

}
