package com.example.service;

import com.example.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TodoService {

    @PersistenceContext private EntityManager entityManager;

    public Todo createTodo(Todo todo) {
        entityManager.persist(todo);
        return todo;
    }

    public Todo updateTodo(Todo todo) {
        return entityManager.merge(todo);
    }

    public Todo findTodoById(Long id) {
        return entityManager.find(Todo.class, id);
    }

    public List<Todo> findAllTodos() {
        return entityManager.createQuery("SELECT t FROM Todo t", Todo.class).getResultList();
    }
}
