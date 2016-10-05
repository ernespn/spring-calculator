package calculator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import calculator.models.Todo;
import calculator.repositories.ITodoRepository;
import calculator.services.TodoService;

public class todoServiceTests {
	private todoBuilder todoBuilder = new todoBuilder();
	
	@Mock
	private ITodoRepository todoRepository;
	
    private TodoService todoService;
	
    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
        todoService = new TodoService(this.todoRepository);
    }
    
	@Test
	public void ItShouldGetListOfTodos() throws Exception{
		List<Todo> list = todoBuilder.AddTodo().Build();
		when(this.todoRepository.findAll()).thenReturn(list);
		
		List<Todo> todos = todoService.GetAllTodos();
		
		assertEquals(list.size(), todos.size());
		verify(todoRepository, times(1)).findAll();
	}
	
	@Test
	public void ItShouldGetById() throws Exception{
		String id = "1";
		List<Todo> list = todoBuilder.AddTodoWithId("2").AddTodoWithId(id).AddTodoWithId("3").Build();
		when(this.todoRepository.findById(id)).thenReturn(list.get(1));
		
		Todo todo = todoService.GetById(id);
		
		assertEquals(id, todo.id);
		verify(todoRepository, times(1)).findById(id);
	}
	
	@Test
	public void ItShouldSaveNewTodo() throws Exception{
		Todo newTodo = new Todo();
		
		todoService.SaveTodo(newTodo);
		
		verify(todoRepository, times(1)).save(newTodo);
	}
	
	@Test
	public void ItShouldDeleteExistingTodo() throws Exception{
		String id = "1";
		List<Todo> list = todoBuilder.AddTodoWithId("2").AddTodoWithId(id).AddTodoWithId("3").Build();
				
		todoService.DeleteTodo(list.get(1));
		
		verify(todoRepository, times(1)).delete(list.get(1));
	}
}
