package co.yedam.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.Reply;

public class ReplyServiceJdbc implements ReplyService{
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
	public boolean add(Reply reply) {
		query="insert into reply values((select nvl(max(rp_no),0)+1 from reply),?,?,?)";
		conn=Dao.conn();
			try {
				psmt=conn.prepareStatement(query);
				psmt.setInt(1, reply.getBrdNo());
				psmt.setString(2, reply.getRpContent());
				psmt.setString(3, reply.getRpWriter());
				int r =psmt.executeUpdate();
				if(r==1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconn();
			}
		return false;
	}
	@Override
	public List<Reply> list(int brdNo) {
		List<Reply> list =new ArrayList<>();
		return null;
	}
	@Override
	public boolean remove(int brdNo, int rpNo) {
		return false;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}
}
