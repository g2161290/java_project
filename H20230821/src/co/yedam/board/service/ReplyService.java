package co.yedam.board.service;

import java.util.List;

import co.yedam.board.vo.Reply;

public interface ReplyService {
	public boolean add(Reply reply);
	
	public List<Reply> list(int brdNo);
	
	public boolean remove(int brdNo, int rpNo);
	
	public void save();
	
}
