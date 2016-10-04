package calculator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import calculator.models.Todo;
import calculator.repositories.ITodoRepository;

@Service
public class TodoService {

	private final ITodoRepository repository;

	@Autowired
	public TodoService(ITodoRepository todoRepository){
		this.repository = todoRepository;
	}

	public List<Todo> GetAllTodos() {
		return this.repository.GetAll();
	}

}
