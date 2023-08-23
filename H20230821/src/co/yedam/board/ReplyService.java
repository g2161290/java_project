package co.yedam.board;

import java.util.List;

public interface ReplyService {
	public boolean add(Reply reply);
	
	public List<Reply> list(int brdNo);
	
	public boolean remove(int brdNo, int rpNo);
	
	public void save();
	
}
