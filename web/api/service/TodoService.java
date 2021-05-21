package api.service;

import api.DAO.TodoDAO;
import api.model.Todo;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TodoService {

    private TodoDAO dao = new TodoDAO();

    public List<Todo> getTodoService(String userId){

        List<Todo> result = null;
        try {
            result = dao.getTodoList(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

//    public List<Todo> getAlreadyDoneTodo(String userId){
//
//    }

    //인증 추가 요함.
    public void createTodoService(String userId, String todo, String date) throws ParseException {
        Todo dto = null;
        int isDone = 0;

        if(!userId.equals("") && !todo.equals("") && !date.equals("")){
            dto = new Todo();
            dto.setUser(userId);
            dto.setTodo(todo);
            dto.setIsDone(isDone);

            Date parsedDate = this.stringToDate(date);
            //저장될 날짜 포멧 예시) 2021/05/12

            dto.setDate(parsedDate);
        }

        try{
            dao.createTodoList(dto);
        }catch (Exception e){
            System.out.println("createTodo error. check TodoService");
            e.printStackTrace();
        }

        return;

    }

    public void updateTodoService(int id, String todo, int isDone, String date){
        Todo dto = null;

        dto = new Todo();
        dto.setTodoId(id);
        dto.setTodo(todo);
        dto.setIsDone(isDone);
        Date parsedDate = this.stringToDate(date);
        dto.setDate(parsedDate);
        try{
            dao.updateTodoList(dto);
        }catch (Exception e){
            System.out.println("updateTodo error. check TodoService");
            e.printStackTrace();
        }
    }

    public void deleteTodoService(int id){
        Todo dto = null;

        dto = new Todo();
        dto.setTodoId(id);
        try{
            dao.deleteTodoList(dto);
        }catch (Exception e){
            System.out.println("deleteTodo error. check TodoService");
            e.printStackTrace();
        }

    }

    public Date stringToDate(String string){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        string = dateFormat.format(new Date());
        Date parsedDate = null;
        try{
            parsedDate = dateFormat.parse(string);
        }catch (ParseException e){
            System.out.println("parse date exception check Todo Service");
            e.getStackTrace();
        }
        return parsedDate;
    }

}
