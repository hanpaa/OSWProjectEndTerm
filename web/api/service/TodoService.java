package api.service;

import api.DAO.TodoDAO;
import api.model.Todo;

import java.sql.SQLException;
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
}
