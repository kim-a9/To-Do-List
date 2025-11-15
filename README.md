# To-Do-List

API simples de uma lista de tarefas, criada para praticar conceitos em Java. Estruturado utilizando os conceitos de Clean Architecture.

# Objetivo
Utilizar operações CRUD (Create, Read, Update e Delete) simples para registrar tarefas, com permanenciaem banco de dados em memória.

# Tecnologias
* Java 21
* Spring Boot 3
* H2 Database
* Spring Boot Starter Data JPA
* Postman/Apidog (extensão para Intellij)

# Endpoint
```console
    | Método | Endpoint | Descrição | 
    | POST | /todo | Registra uma nova tarefa
    | GET | /todo | Busca por todas as tarefas
    | GET | /todo/{id} | Consulta tarefas por id
    | PUT | /todo/{id} | Edita informações de uma tarefa
    | DELETE | /todo/{id} | Exclui uma tarefa da lista
  
```

# Instalação e Execução
### Clone o repositório: 
```console
https://github.com/kim-a9/To-Do-List.git
```
### Acesse a pasta do projeto: 
```console
 cd todo-list
```
### Utilize o comando: 
```console
 mvn spring-boot:run 
```

# Testando a API
Exemplos utilizando extensâo no Intellij
1. Adicionar uma nova tarefa ( POST http://localhost:8080/todo )
![Post task](docs/tests/new-post-todo.png) 

2. Buscar todas as tarefas ( GET http://localhost:8080/todo )
![Get task](docs/tests/new-getall-todo.png)

3. Buscar tarefa por id ( GET http://localhost:8080/todo/{id} )
![Get task id](docs/tests/new-getid-todo.png)

4. Atualizar informações da tarefa ( PUT http://localhost:8080/todo/{id} )
![Put task](docs/tests/new-put-todo.png)

5. Deletar tarefa ( DELETE http://localhost:8080/todo/{id} )
![Delete task](docs/tests/new-delete-todo.png)
