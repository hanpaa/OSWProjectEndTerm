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
            //DB 정보 입력!
            String id = "root";
            String pw = "chlwpgus123"; // 추후 텍스트 처리
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/web_programming?useUnicode=true&characterEncoding=utf8", id, pw);

            System.out.println("mysql connected");

        } catch (Exception e){
            e.getStackTrace();
            System.out.println("MySQL Connect fail");
        }

    }

    //SQL문 DB에 삽입.
    public List<Todo> getTodoList(String userId) throws SQLException{
        String sql = "SELECT * FROM web_programming.todos WHERE user=? ORDER BY date ASC";
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
            todoDTO.setPriority(rs.getInt("priority"));
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
                "isDone =?, date = ?, priority = ? WHERE id = ?";
        try{
            prestate = connection.prepareStatement(sql);
            prestate.setString(1, dto.getTodo());
            prestate.setInt(2, dto.getIsDone());
            java.sql.Date sqlDate = new java.sql.Date(dto.getDate().getTime());
            prestate.setDate(3, sqlDate);
            prestate.setInt(4, dto.getPriority());
            prestate.setInt(5, dto.getTodoId());

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
            //DB내의 ID를 자동적으로 제 배열을 하려고 했으나..... 삭제
//            sql =   "SET sql_safe_updates=0;"+
//                    "ALTER TABLE web_programming.todos AUTO_INCREMENT=1;" +
//                    "SET @COUNT = 0;" +
//                    "UPDATE web_programming.todos SET id = @COUNT:=@COUNT+1;";
//            prestate = connection.prepareStatement(sql);
//            excuteResult = prestate.executeUpdate();
//            if(excuteResult < 0){
//                System.out.println("autoIncreasement fail");
//                return;
//            }
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
