package com.todo.webservices.restwebservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todo.webservices.restwebservices.dao.TodoDao;


@Repository 
public interface TodoRepository extends CrudRepository<TodoDao, Long> {
	
}
