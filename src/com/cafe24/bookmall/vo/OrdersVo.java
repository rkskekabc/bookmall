package com.cafe24.bookmall.vo;

public class OrdersVo {
	private Long no;
	private String ordersNo;
	private String status;
	private int ordersPrice;
	private String destination;
	
	private Long memberNo;
	private String memberName;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(String ordersNo) {
		this.ordersNo = ordersNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOrdersPrice() {
		return ordersPrice;
	}

	public void setOrdersPrice(int ordersPrice) {
		this.ordersPrice = ordersPrice;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "OrdersVo [no=" + no + ", ordersNo=" + ordersNo + ", status=" + status + ", ordersPrice=" + ordersPrice
				+ ", destination=" + destination + ", memberNo=" + memberNo + ", memberName=" + memberName + "]";
	}

}
