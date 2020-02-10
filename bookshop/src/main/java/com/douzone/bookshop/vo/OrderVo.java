package com.douzone.bookshop.vo;

public class OrderVo {

	// order_history Table
	private int no;
	private String orderNo;
	private int memberNo;
	private int orderPrice;
	private String address;
	private String name;
	private String email;

	// order_book Table
	private String title;
	private int quantity;
	private int bookNo;
	private int orderBookNo; // order_book에서 주문번호 확인을 위한 변수

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getOrderBookNo() {
		return orderBookNo;
	}

	public void setOrderBookNo(int orderBookNo) {
		this.orderBookNo = orderBookNo;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", orderNo=" + orderNo + ", memberNo=" + memberNo + ", orderPrice=" + orderPrice
				+ ", address=" + address + ", name=" + name + ", email=" + email + ", title=" + title + ", quantity="
				+ quantity + ", bookNo=" + bookNo + ", orderBookNo=" + orderBookNo + "]";
	}

}
