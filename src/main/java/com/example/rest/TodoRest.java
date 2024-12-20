package com.example.rest;

import com.example.entity.Todo;
import com.example.service.TodoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {

    private final TodoService todoService;

    @Inject
    public TodoRest(TodoService todoService) {
        this.todoService = todoService;
    }

    @Path("new")
    @POST
    public Response createTodo(Todo todo) {
        return Response.ok(todoService.createTodo(todo)).build();
    }

    @Path("update")
    @PUT
    public Response updateTodo(Todo todo) {
        return Response.ok(todoService.updateTodo(todo)).build();
    }

    @Path("{id}")
    @GET
    public Todo getTodo(@PathParam("id") Long id) {
        return todoService.findTodoById(id);
    }

    @Path("list")
    @GET
    public List<Todo> getAllTodos() {
        return todoService.findAllTodos();
    }

    @Path("status")
    @POST
    public Response completeTodo(@QueryParam(value = "id") Long id) {
        Todo t = todoService.findTodoById(id);
        t.setCompleted(true);
        t.setDateCompleted(LocalDate.now());
        return Response.ok(todoService.updateTodo(t)).build();
    }
}
