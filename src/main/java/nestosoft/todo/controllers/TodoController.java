package nestosoft.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nestosoft.todo.models.Todo;
import nestosoft.todo.services.TodoService;

@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@CrossOrigin
	@RequestMapping(value="/todo", method=RequestMethod.GET)
	public List<Todo> GetAllTodos(){
		return this.todoService.GetAllTodos();
	}
	
	@CrossOrigin
	@RequestMapping(value="/todo/{id}", method=RequestMethod.GET)
	public Todo GetById(@PathVariable String id){
		return this.todoService.GetById(id);
	}
	
	@CrossOrigin
	@RequestMapping(value="/todo", method=RequestMethod.POST)
	public void SaveTodo(@RequestBody Todo todo){
		this.todoService.SaveTodo(todo);
	}
	
	@CrossOrigin
	@RequestMapping(value="/todo/{id}", method=RequestMethod.DELETE)
	public void DeleteTodo(@PathVariable String id){
		this.todoService.DeleteTodo(id);
	}
}
