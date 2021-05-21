package api.DAO;

import api.model.Todo;
import com.sun.xml.internal.bind.v2.TODO;

import javax.sql.DataSource;
import java.sql.*;
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

            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/web_programming", id, pw);

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

    //SQL 데이터를 JSON 형식으로 변환
    public List<Todo> getList(ResultSet rs) throws SQLException{
        List<Todo> todoList = new ArrayList<Todo>();
        while(rs.next()){
            Todo todoDTO = new Todo();
            todoDTO.setTodoId(rs.getInt("id"));
            todoDTO.setUser(rs.getString("user"));
            todoDTO.setTodo(rs.getString("todo"));
            todoDTO.setIsDone(rs.getInt("isDone"));
            todoDTO.setDate(rs.getDate("date"));
            todoDTO.setGroup(rs.getString("group"));
            todoList.add(todoDTO);
        }
        return todoList;
    }

    public void createTodoList(Todo dto) throws SQLException {
        String sql = "INSERT INTO web_programming.todos (id, user, todo, isDone, date)"
                +"VALUES(default, ?, ?, ?, ?)";
        try{
            prestate = connection.prepareStatement(sql);
            prestate.setString(1, dto.getUser());
            prestate.setString(2, dto.getTodo());
            prestate.setInt(3, dto.getIsDone());
            java.sql.Date sqlDate = new java.sql.Date(dto.getDate().getTime());
            prestate.setDate(4, sqlDate);
            int excuteResult = prestate.executeUpdate();
            if(excuteResult < 0){
                System.out.println("INSERT QUERY fail");
                return;
            }
            System.out.println("create excuted");
        }catch (SQLException e){
            System.out.println("SQL CREATE ERROR check createTodoList");
            e.printStackTrace();
        }finally {
            if(result != null)
                result.close();
            if(prestate != null)
                prestate.close();
            if(connection != null)
                connection.close();
            return;
        }
    }

    public void updateTodoList(Todo dto) throws SQLException {
        String sql = "UPDATE web_programming.todos SET todo = ?," +
                "isDone =?, date = ? WHERE id = ?";
        try{
            prestate = connection.prepareStatement(sql);
            prestate.setString(1, dto.getTodo());
            prestate.setInt(2, dto.getIsDone());
            java.sql.Date sqlDate = new java.sql.Date(dto.getDate().getTime());
            prestate.setDate(3, sqlDate);
            prestate.setInt(4, dto.getTodoId());
            int excuteResult = prestate.executeUpdate();
            if(excuteResult < 0){
                System.out.println("INSERT QUERY fail");
                return;
            }
            System.out.println("update excuted");
;        }catch (SQLException e){
            System.out.println("SQL UPDATE ERROR check createTodoList");
            e.printStackTrace();
        }finally {
            if(result != null)
                result.close();
            if(prestate != null)
                prestate.close();
            if(connection != null)
                connection.close();
            return;
        }
    }

    public void deleteTodoList(Todo dto) throws SQLException{
        String sql = "DELETE FROM web_programming.todos WHERE id =?";
        try{
            prestate = connection.prepareStatement(sql);
            prestate.setInt(1, dto.getTodoId());
            int excuteResult = prestate.executeUpdate();
            if(excuteResult < 0){
                System.out.println("DELETE QUERY fail");
                return;
            }
            System.out.println("delete excuted");
        }catch (SQLException e){
            System.out.println("SQL DELETE ERROR check createTodoList");
            e.printStackTrace();
        }finally {
            if(result != null)
                result.close();
            if(prestate != null)
                prestate.close();
            if(connection != null)
                connection.close();
            return;
        }
    }

}
