package com.cafe24.bookmall.vo;

public class CartVo {
	private Long memberNo;
	private Long bookNo;
	private int count;
	
	private int price;
	
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CartVo [memberNo=" + memberNo + ", bookNo=" + bookNo + ", count=" + count + ", price=" + price + "]";
	}
}
