# spring-calculator
really simple calculator using spring REST and Docker

# Requirements
- Java 8
- Maven 3.3.9
- STS (optional)

# Usage
- STS:
-- import maven project
-- run it
-- visit http://localhost:8081/add/2/3
- Docker
-- Docker build -rm -t imagename .
-- Docker run -p 8081:8081 imagename
-- visit http://{docker-machine ip}:8081/add/2/3
