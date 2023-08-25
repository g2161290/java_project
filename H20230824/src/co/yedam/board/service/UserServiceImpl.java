package co.yedam.board.service;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.vo.User;

public class UserServiceImpl implements UserService {
// users.txt 에서 정보를 읽고 
	// User정보를 List컬랙션에 저장.
// User 클래스 생성.
	List<User> userList = new ArrayList<>();

	public UserServiceImpl() {
		loadFile();
	}

	@Override
	public User checkLogin(User user) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserId().equals(user.getUserId())) {
				if (userList.get(i).getUserPw().equals(user.getUserPw())) {
					return userList.get(i);
				}
			}
		}
		return null;
	}

	void loadFile() {
		try {
			FileReader fr = new FileReader("c:/temp/users.txt");
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String str = br.readLine();
				if (str == null) {
					break;
				}
				String[] data = str.split(" ");
				userList.add(new User(data[0], data[1], data[2]));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean changePw(String id,String pw) {
		try {
			FileWriter fw = new FileWriter("c:/temp/users.txt");
			for(User u : userList){
				if(u.getUserId().equals(id)) {
					u.setUserPw(pw);
					
				}
				fw.write(u.getUserId()+" "+u.getUserPw()+" "+u.getUserNm());
			}
			fw.flush();
			fw.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
