package com.todo.webservices.restwebservices.dao;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TodoDao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long todoId;

	private String userName;
	
	private String todoDesc;
	
	private Date targetDate;
	
	private boolean isCompleted;

	public Long getTodoId() {
		return todoId;
	}

	public void setTodoId(Long todoId) {
		this.todoId = todoId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getTodoDesc() {
		return todoDesc;
	}

	public void setTodoDesc(String todoDesc) {
		this.todoDesc = todoDesc;
	}



	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public TodoDao() {
		// TODO Auto-generated constructor stub
	}

	public TodoDao(Long todoId, String userName, String todoDesc, Date targetDate, boolean isCompleted) {
		super();
		this.todoId = todoId;
		this.userName = userName;
		this.todoDesc = todoDesc;
		this.targetDate = targetDate;
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "TodoDTO [todoId=" + todoId + ", userName=" + userName + ", todoDesc=" + todoDesc + ", targetDate="
				+ targetDate + ", isCompleted=" + isCompleted + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(isCompleted, targetDate, todoDesc, todoId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoDao other = (TodoDao) obj;
		return isCompleted == other.isCompleted && Objects.equals(targetDate, other.targetDate)
				&& Objects.equals(todoDesc, other.todoDesc) && todoId == other.todoId
				&& Objects.equals(userName, other.userName);
	}
	
}
