package com.douzone.bookshop.vo;

public class CategoryVo {
	private int no;
	private String kind;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", kind=" + kind + "]";
	}

}
