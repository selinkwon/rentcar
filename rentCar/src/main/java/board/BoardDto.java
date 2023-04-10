package board;

public class BoardDto {
	int contentNum,userCode;
	String name,content,title,addDate,date;
	
	public BoardDto(int contentNum, int userCode, String name, String content, String title, String addDate, String date) {
		this.contentNum = contentNum;
		this.userCode = userCode;
		this.name = name;
		this.content = content;
		this.title = title;
		this.addDate = addDate;
		this.date = date;
	}

	public int getContentNum() {
		return contentNum;
	}

	public void setContentNum(int contentNum) {
		this.contentNum = contentNum;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
