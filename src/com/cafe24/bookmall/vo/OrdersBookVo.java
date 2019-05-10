package com.cafe24.bookmall.vo;

public class OrdersBookVo {
	private Long ordersNo;
	private Long bookNo;
	private int count;
	public Long getOrdersNo() {
		return ordersNo;
	}
	public void setOrdersNo(Long ordersNo) {
		this.ordersNo = ordersNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "OrdersBookVo [ordersNo=" + ordersNo + ", bookNo=" + bookNo + ", count=" + count + "]";
	}
}
