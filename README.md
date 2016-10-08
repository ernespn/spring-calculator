# spring-calculator
really simple calculator using spring REST and Docker

# Requirements
- Java 8
- Maven 3.3.9
- STS (optional)

# Usage
## STS:
- import maven project
- run it
- visit http://localhost:8081/add/2/3

## Docker :
- Docker build -rm -t imagename .
- Docker run -p 8081:8081 imagename
- visit http://{docker-machine ip}:8081/add/2/3

#Spring Todo service

# Requirements
- Same than the calculator
- mongodb

# Usage
## STS:
- import maven project
- run it
- http://localhost:8081/todo -> to get all
- http://localhost:8081/todo/1 -> to get the todo with the ID = 1
- http://localhost:8081/todo (POST {"id":"5", "what":"something to do"}) -> to insert a new todo
- http://localhost:8081/todo/1 (DELETE) -> to delete the todo with id = 1


## Mongo DB
- Build a mongo container: docker build db/
- Run the container: docker run -p 27017:27017 --name mongo_dev_instance -d mongo
- Change the host and port to point to that container in application.properties 
