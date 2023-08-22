package co.yedam.board;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
	
	List<User> userList= new ArrayList<>();;
	public UserServiceImpl() {
		loadFile();
	}
	
	@Override
	public boolean checkLogin(User user) {
			
		for(int i=0; i<userList.size();i++) {
			if(userList.get(i).getId().equals(user.getId())&&userList.get(i).getPw().equals(user.getPw())) {
				return true;
			}
		}
		return false;
	}
	void loadFile() {
		FileReader fr = null;
		try {
			fr = new FileReader("c:/temp/user.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br=new BufferedReader(fr);
		
	while(true) {
		String str = null;
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(str==null) {
			break;
		}
		String[] data=str.split(" ");
		User newUser = null;
		newUser = new User(data[0], data[1], data[2]);
		userList.add(newUser);
	}
	}
	
}
