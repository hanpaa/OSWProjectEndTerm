package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	private Connection conn;//데이터베이스에 접근하게 해주는 하나의 객체
	private PreparedStatement pstmt;//
	private ResultSet rs;//정보를 담을 수 있는 객체

	public UserDAO() {//mysql에 접속을 하게 해줌,자동으로 데이터베이스 커넥션이 일어남
		try {//예외처리
			String dbURL = "jdbc:mysql://localhost:3306/bbs";
			String dbID="root";
			String dbPasseord="chlwpgus123";
			Class.forName("com.mysql.jdbc.Driver");//mysql드라이버를 찾는다.
			//드라이버는 mysql에 접속할 수 있도록 매개체 역할을 하는 하나의 라이브러리
			conn=DriverManager.getConnection(dbURL,dbID,dbPasseord);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int login(String userID, String userPassword) {//로그인을 시도하는 함수
		String SQL="SELECT userPassword FROM USER WHERE userID = ?";
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,userID);//아이디가 일치하면 비밀번호를 가져온다.
			rs=pstmt.executeQuery();//rs에 실행한 결과를 넣어준다.
			if(rs.next()) {//결과가 존재한다면
				if(rs.getString(1).equals(userPassword))//sql문장을 실행해서 나온 결과와 접속을 시도했던 passwd비교
					return 1;//로그인 성공
				else
					return 0; //비밀번호 불일치
			}
			return -1;//아이디가 없음,rs의 결과가 존재 하지 않음
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -2; //데이터베이스 오류
	}


	public int join(User user) {
		String SQL = "INSERT INTO USER VALUES (?,?,?,?)";//총 네개의 값이 들어갈 수 있도록 한다.
		try {//insert문장의 결과는 0이상의 숫자가 발현되기 떄문에 -1이 아닌경우는 성공적인 회원가입이 이뤄졌다.
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserEmail());
			return pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();//예외처리
		}
		return -1;//데이터베이스 오류
	}
}
