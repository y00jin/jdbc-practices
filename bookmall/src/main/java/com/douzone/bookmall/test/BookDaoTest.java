package com.douzone.bookmall.test;

import java.util.List;
import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {
	
	public static void main(String[] args) {
//		insertTest("뉴문",1L);
//		insertTest("에옹이",1L);
		selectTest();
		System.out.println();
		deleteTest(12L);
		System.out.println();
		selectTest();
	}
	
	public static void insertTest(String title, Long authorNo) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setAuthorNo(authorNo);
		new BookDao().insert(vo);
	}
	
	public static void selectTest() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void updateStateTest(String title) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		new BookDao().updateState(vo);
	}
	
	public static void updateTitleTest(String title, Long no) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setNo(no);
		new BookDao().updateTitle(vo);
	}

	public static void deleteTest(Long no) {
		BookVo vo = new BookVo();
		vo.setNo(no);
		new BookDao().deleteTitle(vo);
	}
	
}
