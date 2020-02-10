package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douozne.bookshop.dao.OrderDao;
import com.douzone.bookshop.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {
//		insertOrderTest("20200202-00001", 1, 25000, "강원도 춘천시");
		insertOrderBookTest(1,2,1);
		selectTest();
	}

	public static void insertOrderTest(String orderNo, int memberNo, int orderPrice, String address) {
		OrderVo vo = new OrderVo();
		vo.setOrderNo(orderNo);
		vo.setMemberNo(memberNo);
		vo.setOrderPrice(orderPrice);
		vo.setAddress(address);
		new OrderDao().insertOrder(vo);
	}

	public static void insertOrderBookTest(int orderNo, int bookNo, int quantity) {
		OrderVo vo = new OrderVo();
		vo.setOrderBookNo(orderNo);
		vo.setBookNo(bookNo);
		vo.setQuantity(quantity);
		new OrderDao().insertOrderBook(vo);
	}
	
	public static void selectTest() {
		List<OrderVo> list = new OrderDao().selectOrder();
		for (OrderVo vo : list) {
			System.out.println(vo);
		}
	}

}