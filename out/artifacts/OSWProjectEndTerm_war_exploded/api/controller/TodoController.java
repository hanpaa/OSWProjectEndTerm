package api.controller;

import api.model.*;
import api.service.TodoService;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
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
        result = service.getTodo(userId);
        return result;
    }

    @Path("{isdone}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Todo getAlreadyDoneTodo(@PathParam("isdone")String isDone){
        System.out.println("isDone => @get");
        Todo result = null;

        return null;
    }

    //POST 로 받은 생성 요청 연결
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Todo createTodo(@FormParam("userid") String userId,
                           @FormParam("todo") String todo,
                           @FormParam("date") String date) throws ParseException {
        System.out.println("createTodo => @POST");
        Todo result = null;
        result = service.createTodo(userId, todo, date);
        return null;
    }


    @Path("{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Todo updateTodo(@FormParam("id") int id,
                           @FormParam("todo") String todo,
                           @FormParam("isdone") int isDone,
                           @FormParam("date") String date){

        System.out.println("Todo => @PUT");
        Todo result = null;

        return null;
    }

    @Path("{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Todo deleteTodo(@PathParam("id") int id){

        System.out.println("Todo delete => @DELETE");
        List<Todo> reuslt = null;

        return null;

    }


}
