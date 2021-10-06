package bookmall.vo;

public class OrderVo {
	private Long no;
	private int orderNum;
	private int payprice;
	private String shipaddress;
	private Long memberNo;
	
	
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getPayprice() {
		return payprice;
	}
	public void setPayprice(int payprice) {
		this.payprice = payprice;
	}
	public String getShipaddress() {
		return shipaddress;
	}
	public void setShipaddress(String shipaddress) {
		this.shipaddress = shipaddress;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", orderNum=" + orderNum + ", payprice=" + payprice + ", shipaddress="
				+ shipaddress + ", memberNo=" + memberNo + "]";
	}
	
	
	
	
}
