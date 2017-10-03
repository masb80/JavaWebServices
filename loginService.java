package service;

import java.util.HashMap;

import service.dto.User;

public class loginService {
	HashMap<String,String>users= new HashMap<String, String>();
	public loginService(){
		users.put("johndoe", "John Doe");
		users.put("johnedoe", "Johne Doe");
		users.put("jguru", "Java Guru");
	}
	
	public boolean authenticate(String userId, String password){
		if(password == null || password.trim() == ""){
			return false;
		}
		return true;
	}
	public User getUserDetails(String userId){
		User user = new User();
		user.setUserName(users.get(userId));
		return user;
		
	}

}
