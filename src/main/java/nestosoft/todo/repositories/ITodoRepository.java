package nestosoft.todo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import nestosoft.todo.models.Todo;

@Repository
public interface ITodoRepository extends MongoRepository<Todo, String> {

	Todo findById(String string);

}
