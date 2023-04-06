package user;

public class UserRequestDto {
	private int user_code;
	private String name,id,password,contact,joindate;

	public UserRequestDto(int user_code, String name, String id, String password, String contact, String joindate) {
		this.user_code = user_code;
		this.name = name;
		this.id = id;
		this.password = password;
		this.contact = contact;
		this.joindate = joindate;
	}
	
	public UserRequestDto(String name, String id, String password, String contact, String joindate) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.contact = contact;
		this.joindate = joindate;
	}

	public int getUser_code() {
		return user_code;
	}

	public void setUser_code(int user_code) {
		this.user_code = user_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	
}
