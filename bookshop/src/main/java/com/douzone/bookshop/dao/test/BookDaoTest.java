package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douozne.bookshop.dao.BookDao;
import com.douzone.bookshop.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {

//		insertTest(1, "총균쇠", 15000);
//		insertTest(2, "이것이 자바다", 10000);
		selectTest();
//		updateTest("예술",2);
//		selectTest();
	}

	public static void insertTest(int cat_no, String title, int price) {
		BookVo vo = new BookVo();
		vo.setCategoryNo(cat_no);
		vo.setTitle(title);
		vo.setPrice(price);
		new BookDao().insert(vo);
	}

	public static void selectTest() {
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}

}
