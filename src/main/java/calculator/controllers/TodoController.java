package calculator.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import calculator.models.Todo;
import calculator.services.TodoService;

@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value="/todo", method=RequestMethod.GET)
	public List<Todo> GetAllTodos(){
		return this.todoService.GetAllTodos();
	}
	
	@RequestMapping(value="/todo/{id}", method=RequestMethod.GET)
	public Todo GetById(@PathVariable String id){
		return this.todoService.GetById(id);
	}
	
	@RequestMapping(value="/todo", method=RequestMethod.POST)
	public void SaveTodo(@RequestBody Todo todo){
		this.todoService.SaveTodo(todo);
	}
	
	@RequestMapping(value="/todo/{id}", method=RequestMethod.DELETE)
	public void SaveTodo(@PathVariable String id){
		this.todoService.DeleteTodo(id);
	}
}
