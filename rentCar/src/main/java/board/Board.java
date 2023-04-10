package board;

public class Board {
	int contentNum,userCode;
	String name,content,title,addDate,date;
	
	public Board(int contentNum, int userCode, String name, String content, String title, String addDate, String date) {
		this.contentNum = contentNum;
		this.userCode = userCode;
		this.name = name;
		this.content = content;
		this.title = title;
		this.addDate = addDate;
		this.date = date;
	}
	
	public Board(int contentNum, int userCode, String name, String content, String title, String addDate) {
		this.contentNum = contentNum;
		this.userCode = userCode;
		this.name = name;
		this.content = content;
		this.title = title;
		this.addDate = addDate;
	}
	
	public Board(BoardDto boardDto) {
		this.contentNum = boardDto.getContentNum();
		this.userCode = boardDto.getUserCode();
		this.name = boardDto.getName();
		this.content = boardDto.getContent();
		this.title = boardDto.getTitle();
		this.addDate = boardDto.getAddDate();
		this.date = boardDto.getDate();
	}

	public int getContentNum() {
		return contentNum;
	}

	public int getUserCode() {
		return userCode;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public String getTitle() {
		return title;
	}

	public String getAddDate() {
		return addDate;
	}

	public String getDate() {
		return date;
	}
	
	
}
