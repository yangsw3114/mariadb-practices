package bookmall.vo;

public class OrderbookVo {
	private Long bookNo;
	private Long orderNo;
	private int count;

	
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "OrderbookVo [bookNo=" + bookNo + ", orderNo=" + orderNo + ", count=" + count + "]";
	}
	
	
	
	
	
}
