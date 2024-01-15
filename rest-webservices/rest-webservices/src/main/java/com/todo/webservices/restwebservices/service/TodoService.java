package com.todo.webservices.restwebservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.webservices.restwebservices.dao.TodoDao;
import com.todo.webservices.restwebservices.model.TodoDTO;
import com.todo.webservices.restwebservices.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository repository;

	private static List<TodoDTO> todoList;

	static {
		todoList = new ArrayList<>();
		todoList.add(new TodoDTO(1, "suma", "learnToDance", new Date(), false));
		todoList.add(new TodoDTO(2, "suma", "learnSpringboot", new Date(), false));
		todoList.add(new TodoDTO(3, "suma", "learnMVC", new Date(), false));
	}

	public List<TodoDTO> findAll(String userName) {

		return todoList;
	}

	public void deleteById(String userName, long id) {
		
		repository.deleteById(id);

	}

	public TodoDTO findById(int todoId) {

		TodoDao dao = repository.findById((long) todoId).get();

		return convertDaoToDto(dao);
	}

	public TodoDTO update(String userName, int todoId, TodoDTO todo) {

		TodoDTO existingTodo = findById(todoId);

		existingTodo.setTargetDate(todo.getTargetDate());
		existingTodo.setTodoDesc(todo.getTodoDesc());
		
		return convertDaoToDto(repository.save(convertDtoToDao(existingTodo)));

	}

	public TodoDTO save(TodoDTO todoDto) {
				
		TodoDao todoDao = repository.save(convertDtoToDao(todoDto));
		
		return convertDaoToDto(todoDao);
		
	}

	public TodoDTO convertDaoToDto(TodoDao todoDao) {

		TodoDTO todoDto = new TodoDTO();

		todoDto.setTodoId(todoDao.getTodoId());
		todoDto.setTodoDesc(todoDao.getTodoDesc());
		todoDto.setTargetDate(todoDao.getTargetDate());
		todoDto.setCompleted(todoDao.isCompleted());

		return todoDto;
	}
	
	public TodoDao convertDtoToDao(TodoDTO todoDto) {

		TodoDao todoDao = new TodoDao();

		todoDao.setTodoId(todoDto.getTodoId());
		todoDao.setTodoDesc(todoDto.getTodoDesc());
		todoDao.setTargetDate(todoDto.getTargetDate());
		todoDao.setCompleted(todoDto.isCompleted());

		return todoDao;
	}
}
//https://www.amitph.com/avoid-nullpointerexception-using-java-8-optional/