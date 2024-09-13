package com.example.todolist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.entity.Todo;
import com.example.todolist.service.TodoService;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public List<Todo> createTodo(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @PutMapping
    public List<Todo> updateTodo(@RequestBody Todo todo) {
        return todoService.update(todo);

    }

    @GetMapping
    public List<Todo> listTodos() {
        return todoService.list();
    }

    @DeleteMapping("{id}")
    public List<Todo> deleteTodo(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }

}