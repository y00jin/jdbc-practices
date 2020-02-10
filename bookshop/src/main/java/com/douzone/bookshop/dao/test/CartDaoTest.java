package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douozne.bookshop.dao.CartDao;
import com.douzone.bookshop.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {
		
//		insertTest(1,9,1);
		selectTest();
	}

	public static void insertTest(int memberNo, int bookNo, int amount) {
		CartVo vo = new CartVo();
		vo.setMemberNo(memberNo);
		vo.setBookNo(bookNo);
		vo.setAmount(amount);
		new CartDao().insert(vo);
	}

	public static void selectTest() {
		List<CartVo> list = new CartDao().findAll();
		for (CartVo vo : list) {
			System.out.println(vo);
		}
	}

}
