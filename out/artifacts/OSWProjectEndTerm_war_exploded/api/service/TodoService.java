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

    public List<Todo> getTodo(String userId){

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
    public Todo createTodo(String userId, String todo, String date) throws ParseException {
        Todo result = null;
        Todo dto = null;
        int isDone = 0;

        if(!userId.equals("") && !todo.equals("") && !date.equals("")){
            dto = new Todo();
            dto.setUser(userId);
            dto.setTodo(todo);
            dto.setIsDone(isDone);

            //저장될 날짜 포멧 예시) 2021/05/12
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            date = dateFormat.format(new Date());
            Date parsedDate = null;
            try{
                parsedDate = dateFormat.parse(date);
            }catch (ParseException e){
                System.out.println("parse date exception check Todo Service");
                e.getStackTrace();
            }
            dto.setDate(parsedDate);
        }

        try{
            result = dao.createTodoList(dto);
        }catch (Exception e){
            System.out.println("createTodo error. check TodoService");
            e.printStackTrace();
        }

        return result;

    }

}
