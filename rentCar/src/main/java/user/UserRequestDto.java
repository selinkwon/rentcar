package user;

public class UserRequestDto {
	private int userCode;
	private String name,id,password,contact,joindate;

	public UserRequestDto(int userCode, String name, String id, String password, String contact, String joindate) {
		this.userCode = userCode;
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

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
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
