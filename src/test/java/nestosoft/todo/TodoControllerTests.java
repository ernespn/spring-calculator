package nestosoft.todo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import nestosoft.todo.models.Todo;
import nestosoft.todo.services.TodoService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TodoControllerTests {

	private todoBuilder todoBuilder = new todoBuilder();	
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@MockBean
	private TodoService todoService;

    @Test
    public void ItShouldGetListOfTodos() throws Exception {
    	String id = "ThisisAndId";
    	List<Todo> expectedList = todoBuilder.AddTodo().AddTodoWithId(id).GetTodoList();
    	when(this.todoService.GetAllTodos()).thenReturn(expectedList);
	
    	@SuppressWarnings("unchecked")
		List<Todo> actualList = this.restTemplate.getForObject("/todo", List.class);
        
    	assertThat(expectedList.size()).isEqualTo(actualList.size());
    	verify(this.todoService, times(1)).GetAllTodos();
    }
    
    @Test
    public void ItShouldGetSpecificTodo() throws Exception {
    	String id = "ThisisAndId";
    	Todo expectedTodo = todoBuilder.AddTodoWithId(id).GetTodoList().get(0);
    	when(this.todoService.GetById(id)).thenReturn(expectedTodo);
    	
    	Todo todo = this.restTemplate.getForObject("/todo/"+id, Todo.class);
        
    	assertThat(expectedTodo).isEqualToComparingFieldByField(todo);
    	verify(todoService, times(1)).GetById(id);
    }
    
    @Test
    public void ItShouldPostANewTodo() throws Exception {
    	String id = "ThisisAndId";
    	Todo newTodo = todoBuilder.AddTodoWithId(id).GetFirstTodo();
       	    	
    	this.restTemplate.postForObject("/todo", GenerateHttpContext(newTodo), Map.class, Collections.emptyMap());
        
    	verify(todoService, times(1)).SaveTodo(any(Todo.class));;
    }
    
    @Test
    public void ItShouldDeleteAnExistingTodo() throws Exception {
    	String id = "ThisisAndId";
       	    	
    	this.restTemplate.delete("/todo/"+id);
        
    	verify(todoService, times(1)).DeleteTodo(id);
    }
    
    private HttpEntity<String> GenerateHttpContext(Todo todo) throws JsonProcessingException{
    	ObjectMapper mapper = new ObjectMapper();
    	Map<String, Object> requestBody = new HashMap<String, Object>();
    	requestBody.put("id", todo.id);
    	requestBody.put("what", todo.what);
  		HttpHeaders requestHeaders = new HttpHeaders();
  		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

    	//Creating http entity object with request body and headers
    	HttpEntity<String> httpEntity =
    	      new HttpEntity<String>(mapper.writeValueAsString(requestBody), requestHeaders);

    	return httpEntity;

    }

}

