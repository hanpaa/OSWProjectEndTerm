package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {

	private Connection conn;//�����ͺ��̽��� �����ϰ� ���ִ� �ϳ��� ��ü
	private ResultSet rs;//������ ���� �� �ִ� ��ü

	public BbsDAO() {//mysql�� ������ �ϰ� ����,�ڵ����� �����ͺ��̽� Ŀ�ؼ��� �Ͼ
		try {//����ó��
			String dbURL = "jdbc:mysql://localhost:3306/bbs";
			String dbID="root";
			String dbPasseord="chlwpgus123";
			Class.forName("com.mysql.jdbc.Driver");//mysql����̹��� ã�´�.
			//����̹��� mysql�� ������ �� �ֵ��� �Ű�ü ������ �ϴ� �ϳ��� ���̺귯��
			conn=DriverManager.getConnection(dbURL,dbID,dbPasseord);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public String getDate() {//���� ���� �ð� ��������
		String SQL="select now()";//���� �ð��� �������� mysql����
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);//sql������ ���� �غ� �ܰ��
			rs=pstmt.executeQuery();//������ ��������
			if(rs.next()) {
				return rs.getString(1);//���� ��¥ ��ȯ
			}

		} catch(Exception e) {
			e.printStackTrace();//���� �߻�
		}
		return "";//�����ͺ��̽� ����
	}

	public int getNext() {
		String SQL="SELECT bbsID from bbs order by bbsID DESC";//������ �Խù� ��ȯ
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; // ù ��° �Խù��� ���

		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;//�����ͺ��̽� ����
	}

	public int write(String bbsTitle, String userID, String bbsContent) {//���� ���� �ð� ��������
		String SQL="insert into bbs VALUES (?, ?, ?, ?, ?, ?)";//������ �Խù� ��ȯ
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());//�Խñ� ��ȣ
			pstmt.setString(2, bbsTitle);//����
			pstmt.setString(3, userID);//���̵�
			pstmt.setString(4, getDate());//��¥
			pstmt.setString(5, bbsContent);//����
			pstmt.setInt(6, 1);//������ ��찡 �ƴϱ� ������ 1�� �־���
			return pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;//�����ͺ��̽� ����
	}

	//�����ͺ��̽����� ���� ����� �������� �ҽ��ڵ� �ۼ�
		public ArrayList<Bbs> getList(int pageNumber){//Ư���� ����Ʈ�� �޾Ƽ� ��ȯ
			String SQL="SELECT * from bbs where bbsID < ? AND bbsAvailable = 1 order by bbsID desc limit 10";
			ArrayList<Bbs> list = new ArrayList<Bbs>();
			try {
				PreparedStatement pstmt=conn.prepareStatement(SQL);
				pstmt.setInt(1, getNext()-(pageNumber-1)*10);//����ǥ�� �� ����
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Bbs bbs = new Bbs();
					bbs.setBbsID(rs.getInt(1));
					bbs.setBbsTitle(rs.getString(2));
					bbs.setUserID(rs.getString(3));
					bbs.setBbsDate(rs.getString(4));
					bbs.setBbsContent(rs.getString(5));
					bbs.setBbsAvailable(rs.getInt(6));
					list.add(bbs);//list�� �ش� �ν��Ͻ��� ��´�.
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return list;//���Ľñ� ����Ʈ ��ȯ
		}

		public boolean nextPage(int pageNumber) {//������ ó���� ���� �Լ�
			String SQL="SELECT * from bbs where bbsID < ? AND bbsAvailable =1";

			try {
				PreparedStatement pstmt=conn.prepareStatement(SQL);
				pstmt.setInt(1, getNext()-(pageNumber-1)*10);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					return true;//���� �������� �Ѿ �� ����
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}

		public Bbs getBbs(int bbsID) {//�ϳ��� �� ������ �ҷ����� �Լ�
			String SQL="SELECT * from bbs where bbsID = ?";
			try {
				PreparedStatement pstmt=conn.prepareStatement(SQL);
				pstmt.setInt(1, bbsID);
				rs=pstmt.executeQuery();//select
				if(rs.next()) {//����� �ִٸ�
					Bbs bbs = new Bbs();
					bbs.setBbsID(rs.getInt(1));//ù ��° ��� ��
					bbs.setBbsTitle(rs.getString(2));
					bbs.setUserID(rs.getString(3));
					bbs.setBbsDate(rs.getString(4));
					bbs.setBbsContent(rs.getString(5));
					bbs.setBbsAvailable(rs.getInt(6));
					return bbs;//6���� �׸��� bbs�ν��Ͻ��� �־� ��ȯ�Ѵ�.
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		public int update(int bbsID, String bbsTitle,String bbsContent ) {
			String SQL="update bbs set bbsTitle = ?, bbsContent = ? where bbsID = ?";//Ư���� ���̵� �ش��ϴ� ����� ������ �ٲ��ش�.
			try {
				PreparedStatement pstmt=conn.prepareStatement(SQL);
				pstmt.setString(1, bbsTitle);//����ǥ�� ����
				pstmt.setString(2, bbsContent);
				pstmt.setInt(3, bbsID);
				return pstmt.executeUpdate();//insert,delete,update
			} catch(Exception e) {
				e.printStackTrace();
			}
			return -1;//�����ͺ��̽� ����
		}

		public int delete(int bbsID) {
			String SQL = "update bbs set bbsAvailable = 0 where bbsID = ?";
			try {
				PreparedStatement pstmt=conn.prepareStatement(SQL);
				pstmt.setInt(1, bbsID);
				return pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			}
			return -1;//�����ͺ��̽� ����
		}
}
