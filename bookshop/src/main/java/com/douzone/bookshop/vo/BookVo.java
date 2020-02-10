package com.douzone.bookshop.vo;

public class BookVo {
	private int no;
	private int categoryNo;
	private String kind;
	private String title;
	private int price;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", categoryNo=" + categoryNo + ", kind=" + kind + ", title=" + title + ", price="
				+ price + "]";
	}

}
