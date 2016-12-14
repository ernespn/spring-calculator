package nestosoft.todo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nestosoft.todo.models.Todo;
import nestosoft.todo.repositories.ITodoRepository;
import nestosoft.todo.services.TodoService;

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
		List<Todo> list = todoBuilder.AddTodo().GetTodoList();
		when(this.todoRepository.findAll()).thenReturn(list);
		
		List<Todo> todos = todoService.GetAllTodos();
		
		assertEquals(list.size(), todos.size());
		verify(todoRepository, times(1)).findAll();
	}
	
	@Test
	public void ItShouldGetById() throws Exception{
		String id = "1";
		List<Todo> list = todoBuilder.AddTodoWithId("2").AddTodoWithId(id).AddTodoWithId("3").GetTodoList();
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
		List<Todo> list = todoBuilder.AddTodoWithId("2").AddTodoWithId(id).AddTodoWithId("3").GetTodoList();
		when(this.todoRepository.findById(id)).thenReturn(list.get(1));
				
		todoService.DeleteTodo(id);
		
		verify(todoRepository, times(1)).findById(id);
		verify(todoRepository, times(1)).delete(list.get(1));
	}
	
	

}
