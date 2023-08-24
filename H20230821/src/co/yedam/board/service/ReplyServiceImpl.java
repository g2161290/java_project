package co.yedam.board.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.vo.Reply;

public class ReplyServiceImpl implements ReplyService{

	List<Reply> replyList = new ArrayList<>();
	
	public ReplyServiceImpl() {
		init();
	}
	
	private void init() {
		try {
			FileInputStream fis=new FileInputStream("c:/temp/reply.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			replyList=(List<Reply>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}
	
	@Override
	public boolean add(Reply reply) {
		reply.setRpNo(getMaxNo());
		return replyList.add(reply);
	}
	private int getMaxNo() {
		int rpNo=0;
		for(int i=0; i< replyList.size();i++) {
			if(replyList.get(i).getRpNo() >rpNo) {
				rpNo=replyList.get(i).getRpNo();
			}
		}
		return rpNo+1;
	}
	@Override
	public List<Reply> list(int brdNo) {
		List<Reply> rList =new ArrayList<>();
		for(int i=0;i<replyList.size();i++) {
			if(replyList.get(i).getBrdNo()==brdNo) {
				rList.add(replyList.get(i));
			}
		}
		return rList;
	}
	
	@Override
	public boolean remove(int brdNo, int rpNo) {
		for(int i=0;i<replyList.size();i++) {
			if(replyList.get(i).getBrdNo()==brdNo&&replyList.get(i).getRpNo()==rpNo) {
				replyList.remove(i);
				return true;
			}
		}
		return false;
	}
	@Override
	public void save() {
		try {
			FileOutputStream fos=new FileOutputStream("C:/temp/reply.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(replyList);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
