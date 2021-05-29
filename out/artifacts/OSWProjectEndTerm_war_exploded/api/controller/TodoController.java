package api.controller;

import api.model.*;
import api.service.TodoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.List;

@Path("/todos/{userid}/todolist")
//@Path("/todos")
public class TodoController {
    private TodoService service = new TodoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getUserTodoList(@PathParam("userid") String userId){
        System.out.println("UserID =>get");
        List<Todo> result = null;
        result = service.getTodoService(userId);
        return result;
    }

    @Path("{isDone}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Todo getAlreadyDoneTodo(@PathParam("isDone")String isDone){
        System.out.println("isDone => @get");
        Todo result = null;

        return null;
    }

    //POST 로 받은 생성 요청 연결
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Todo createTodo(@PathParam("userid") String userId,
                           @FormParam("todo") String todo,
                           @FormParam("date") String date) throws ParseException {
        System.out.println("createTodo => @POST");
        Todo result = null;
        service.createTodoService(userId, todo, date);
        return null;
    }


//    @Path("{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Todo updateTodo(@FormParam("id") int id,
                           @FormParam("todo") String todo,
                           @FormParam("isDone") int isDone,
                           @FormParam("date") String date){

        System.out.println("Todo => @PUT");
        service.updateTodoService(id, todo, isDone, date);

        return null;
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Todo deleteTodo(@PathParam("id") int id){

        System.out.println("Todo delete => @DELETE");
        service.deleteTodoService(id);

        return null;

    }


}
