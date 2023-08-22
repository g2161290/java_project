package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceJdbc implements BoardService{
	
	// Connection 객체.
	// PreparedStatement 객체.
	// ResultSet 객체.
	// String 쿼리.
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;
	
	@Override
	public boolean add(Board board) {
		query= "insert into board (brd_no,brd_title,brd_content,brd_writer) values(";
		return false;
	}
	private int getMaxNo() {
		int brdNo=0;
		query=" select max(brd_no)\r\n"
				+ " from board;";
		conn=Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs=psmt.executeQuery();
			int brdSize =rs.getInt("");
			for(int i=0; i<brdSize;i++) {
				if(boardList.get(i).getBrdNo() >brdNo) {
					brdNo=boardList.get(i).getBrdNo();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<Board>();
		conn = Dao.conn();
		query = "select * from board";
		try {
			psmt = conn.prepareStatement(query);
			rs=psmt.executeQuery();
			while(rs.next()) {
				// rs->list
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdContent(rs.getString("brd_content"));
				board.setBrdWriter(rs.getString("brd_writer"));
				board.setWriteDate(rs.getDate("write_date"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public double getTotal() {
		return 0;
	}

	@Override
	public boolean modify(Board board) {
		query="update board set brd_content"+board.getBrdContent()+"where brd_no="+board.getBrdNo();
		return false;
	}

	@Override
	public boolean remove(int brdNo) {
		query = "delete from board where brd_no="+brdNo;
		conn = Dao.conn();
		try {
			psmt=conn.prepareStatement(query);
			int r =psmt.executeUpdate();// insert, update, delete
			if(r==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Board search(int brdNo) {
		query="select * from board where brd_no="+brdNo;
		conn= Dao.conn();
		try {
			psmt=conn.prepareStatement(query);
			rs=psmt.executeQuery();
			if(rs.next()){
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdContent(rs.getString("brd_content"));
				board.setBrdWriter(rs.getString("brd_writer"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setUpdateDate(rs.getDate("update_date"));
				return board;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save() {
		
	}

}
