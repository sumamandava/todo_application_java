package com.todo.webservices.restwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.webservices.restwebservices.model.TodoDTO;
import com.todo.webservices.restwebservices.service.TodoService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ToDoController {

	@Autowired
	TodoService todoService;

	@GetMapping("/users/{userName}/todos")
	public List<TodoDTO> getTodos(@PathVariable String userName) throws Exception {
		try {
			return todoService.findAll(userName);
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping("/users/{userName}/todos/{todoId}")
	public TodoDTO getTodosById(@PathVariable String userName, @PathVariable("todoId") int todoId) throws Exception {
		try {
			//return todoService.findById(todoId).get();
			 return todoService.findById(todoId);
		} catch (Exception e) {
			return null;
		}
	}

	@DeleteMapping("/users/{userName}/todos/{todoId}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String userName, @PathVariable("todoId") int todoId) {

		return ResponseEntity.noContent().build();
	}

	@PutMapping("/users/{userName}/todos/{todoId}")
	public ResponseEntity<TodoDTO> updateTodo(@PathVariable String userName, @PathVariable("todoId") int todoId,
			@RequestBody TodoDTO todo) {

		try {
			todoService.update(userName, todoId, todo);
			return new ResponseEntity<TodoDTO>(todo, HttpStatus.OK);
		}

		catch (Exception e) {
			return new ResponseEntity<TodoDTO>(todo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/users/{userName}/todos")
	public ResponseEntity<TodoDTO> saveTodo(@PathVariable String userName,
			@RequestBody TodoDTO todo) {
		try {
		todoService.save(todo);
		return new ResponseEntity<TodoDTO>(todo, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<TodoDTO>(todo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	}
	
