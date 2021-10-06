package bookmall.vo;

public class CartVo {
	private Long bookNo;
	private Long memberNo;
	private int count;
	
	
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "CartVo [bookNo=" + bookNo + ", memberNo=" + memberNo + ", count=" + count + "]";
	}
	
	
	
	
}
