package calculator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import calculator.models.Todo;
import calculator.repositories.ITodoRepository;
import calculator.services.TodoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class todoServiceTests {
	private todoBuilder todoBuilder = new todoBuilder();
	
	@MockBean
	private ITodoRepository todoRepository;
	
	@Autowired
    private TodoService todoService;
	
	@Test
	public void ItShouldGetListOfTodos() throws Exception{
		List<Todo> list = todoBuilder.AddTodo().Build();
		when(this.todoRepository.GetAll()).thenReturn(list);
		
		List<Todo> todos = todoService.GetAllTodos();
		
		assertEquals(list.size(), todos.size());
		verify(todoRepository, times(1)).GetAll();
	}
}
