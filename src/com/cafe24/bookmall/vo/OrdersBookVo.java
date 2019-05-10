package com.cafe24.bookmall.vo;

public class OrdersBookVo {
	private Long ordersNo;
	private Long bookNo;
	
	private String ordersName;
	private String bookName;

	private int count;
	private int price;
	
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
	public String getOrdersName() {
		return ordersName;
	}
	public void setOrdersName(String ordersName) {
		this.ordersName = ordersName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "OrdersBookVo [ordersNo=" + ordersNo + ", bookNo=" + bookNo + ", ordersName=" + ordersName
				+ ", bookName=" + bookName + ", count=" + count + ", price=" + price + "]";
	}
	
}
