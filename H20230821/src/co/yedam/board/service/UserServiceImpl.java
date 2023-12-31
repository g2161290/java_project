package co.yedam.board.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.vo.User;

public class UserServiceImpl implements UserService{
	
	List<User> userList= new ArrayList<>();;
	public UserServiceImpl() {
		loadFile();
	}
	
	@Override
	public User checkLogin(User user) {
			
		for(int i=0; i<userList.size();i++) {
			if(userList.get(i).getId().equals(user.getId())&&userList.get(i).getPw().equals(user.getPw())) {
				return userList.get(i);
			}
		}
		return null;
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
