package user;

import user.controller.UserDao;

public class User {
	private int user_code;
	

	private String name,id,password,contact,joindate;

	public User(int user_code, String name, String id, String password, String contact, String joindate) {
		this.user_code = user_code;
		this.name = name;
		this.id = id;
		this.password = password;
		this.contact = contact;
		this.joindate = joindate;
	}
	
	public User(String name, String id, String password, String contact, String joindate) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.contact = contact;
		this.joindate = joindate;
	}
	
	public User(UserRequestDto userDto) {
		UserDao userDao =  UserDao.getInstance();
		this.user_code = userDao.getUserCodeMax()+1;
		this.name = userDto.getName();
		this.id = userDto.getId();
		this.password = userDto.getPassword();
		this.joindate = userDto.getJoindate();
		this.contact = userDto.getContact();
	}
	
	public int getUser_code() {
		return user_code;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getContact() {
		return contact;
	}

	public String getJoindate() {
		return joindate;
	}
}
