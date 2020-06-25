package com.yearup.todosapidemo.service;

import com.yearup.todosapidemo.domain.Todo;
import com.yearup.todosapidemo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    // Mock Database
//    List<Todo> todos = new ArrayList<>(
//            Arrays.asList(
//                    new Todo(
//                            1L,
//                            "Take out the trash",
//                            false
//                    ),
//                    new Todo(
//                            2L,
//                            "Wash dogs",
//                            false
//                    ),
//                    new Todo(
//                            3L,
//                            "Make bed",
//                            false
//                    )
//            )
//    );
    @Autowired
    private TodoRepository todoRepository;

    //TODO Get all of our todos in our database
    public List<Todo> getTodos() {
        //Create an arraylist
        List<Todo> todoList = new ArrayList<>();
        //Loop through the list and add it to the repository
        todoRepository.findAll()
                      .forEach(todoList::add);
        //Return the list
        return todoList;
    }
//
//    //TODO Get a todo by ID
//    public Todo getTodoById(Long id) {
//        //Loop through our list of todos
//        for (Todo todo : todos) {
//            //Check if the todo matches a todo in our mock database
//            if (id.equals(todo.getId())) {
//                //Return the todo object that matches the id
//                return todo;
//            }
//        }
//        return null;
//    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

//    //TODO Add a todo to the ArrayList
//    public void addTodo(Todo todo) {
//        todos.add(todo);
//    }

    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

//    //TODO Update a todo by a TODO ID
//    public void updateTodoByID(Todo todo, Long id) {
//        for(int i = 0; i < todos.size(); i++) {
//            Todo t = todos.get(i);
//            if (t.getId().equals(id)) {
//                todos.set(i, todo);
//            }
//        }
//    }

    public void updateTodoById(Todo todo, Long id) {
        todoRepository.save(todo);
    }

//    //TODO Delete a todo by a todo ID
//    public void deleteTodoById(Long id) {
//        for (int i = 0; i < todos.size(); i++) {
//            if (id.equals(todos.get(i).getId())) {
//                todos.remove(i);
//            }
//        }
//    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}
