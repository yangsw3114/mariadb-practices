package bookshop.example;

public class Book {
	int bookNo;
	String title;
	String author;
	int stateCode;
	
	public Book(int bookNo, String title, String author) {
		this.bookNo=bookNo;
		this.title=title;
		this.author=author;
		this.stateCode=1;
	}
	
	public void rent() {
		this.stateCode=0;
		System.out.println(title+"이(가) 대여됐습니다.");
	}
	
	public String print() {
		String state = null;
		if(stateCode==1) {
			state="재고있음";
		}
		else if(stateCode==0) {
			state="대여중";
		}
		return state;
		
	}
	
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}
