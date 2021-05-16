package api.DAO;

import api.model.Todo;
import com.sun.xml.internal.bind.v2.TODO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
    private Connection connection ;
    private PreparedStatement prestate;
    private ResultSet result;

    static DataSource dataSource;

    public TodoDAO(){
        connection = null;
        try{
            String id = "root";
            String pw = "chlwpgus123"; // 추후 텍스트 처리
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("mysql connected");

        } catch (Exception e){
            e.getStackTrace();
            System.out.println("MySQL Connect fail");
        }

    }

    public List<Todo> getTodoList(String userId) throws SQLException{
        String sql = "SELECT * FROM web_programming.todos WHERE user=?";
        List<Todo> todoList = null;

        try {
            prestate = connection.prepareStatement(sql);
            prestate.setString(1, userId);
            result = prestate.executeQuery();
            todoList = getList(result);
            return todoList;
        }finally {
            if(result != null)
                result.close();
            if(prestate != null)
                prestate.close();
            if(connection != null)
                connection.close();
        }

    }

    public List<Todo> getList(ResultSet rs) throws SQLException{
        List<Todo> todoList = new ArrayList<Todo>();
        while(rs.next()){
            Todo todoDTO = new Todo();
            todoDTO.setTodoId(rs.getInt("id"));
            todoDTO.setTodo(rs.getString("todo"));
            todoDTO.setIsDone(rs.getInt("isDone"));
            todoDTO.setDate(rs.getTimestamp("data"));
            todoList.add(todoDTO);
        }
        return todoList;
    }

}
