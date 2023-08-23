package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceJdbc implements UserService {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;

	void disconn() {
		try {
		if(rs!=null) {
			rs.close();
		}
		if(psmt!=null) {
			psmt.close();
		}
		if(conn!=null) {
			conn.close();
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public User checkLogin(User user) {
		query = "select * from users where user_id =? and user_pw=?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPw());
			rs = psmt.executeQuery();
			if (rs.next()) {
				User newUser = new User(null, null, null);
				newUser.setId(rs.getString("user_id"));
				newUser.setPw(rs.getString("user_pw"));
				newUser.setName(rs.getString("user_nm"));
				return newUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}

}
