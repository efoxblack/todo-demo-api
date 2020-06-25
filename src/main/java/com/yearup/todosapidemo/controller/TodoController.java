package com.yearup.todosapidemo.controller;

import com.yearup.todosapidemo.domain.Todo;
import com.yearup.todosapidemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    //TODO Get all todos using service
    @RequestMapping(method = RequestMethod.GET, value = "/todos")
    public List<Todo> getAllTodos() {
        return todoService.getTodos();
    }

    //TODO Get a todo by ID
    @RequestMapping(method = RequestMethod.GET, value = "/todos/{id}")
    public Optional<Todo> getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    //TODO Add a todo
    @RequestMapping(method = RequestMethod.POST, value = "todos")
    public void addTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
    }

    //TODO Update a todo by ID
    @RequestMapping(method = RequestMethod.PUT, value = "todos/{id}")
    public void updateTodoById(@RequestBody Todo todo, @PathVariable Long id) {
        todoService.updateTodoById(todo, id);
    }

    //TODO Delete a todo by ID
    @RequestMapping(method = RequestMethod.DELETE, value = "todos/{id}")
    public void deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
    }
}
