package api.controller;

import api.model.*;
import api.service.TodoService;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/todos/{userid}/todolist")
//@Path("/todos")
public class Todos {
    private TodoService service = new TodoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getUser(@PathParam("userid") String userId){
        System.out.println("UserID =>get");
        List<Todo> result = null;
        result = service.getTodo(userId);
        return result;
    }

//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Todo> getTodos(){
//        System.out.println("todos=> @GET");
//        List<Todo> res = null;
//
//        return res;
//
//    }



}
