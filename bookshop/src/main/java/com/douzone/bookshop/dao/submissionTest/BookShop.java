package com.douzone.bookshop.dao.submissionTest;

import java.util.List;

import com.douozne.bookshop.dao.BookDao;
import com.douozne.bookshop.dao.CartDao;
import com.douozne.bookshop.dao.CategoryDao;
import com.douozne.bookshop.dao.MemberDao;
import com.douozne.bookshop.dao.OrderDao;
import com.douzone.bookshop.dao.test.BookDaoTest;
import com.douzone.bookshop.dao.test.CartDaoTest;
import com.douzone.bookshop.dao.test.CategoryDaoTest;
import com.douzone.bookshop.dao.test.MemberDaoTest;
import com.douzone.bookshop.dao.test.OrderDaoTest;
import com.douzone.bookshop.vo.BookVo;
import com.douzone.bookshop.vo.CartVo;
import com.douzone.bookshop.vo.CategoryVo;
import com.douzone.bookshop.vo.MemberVo;
import com.douzone.bookshop.vo.OrderVo;

public class BookShop {

	public static void main(String[] args) {
//		insertData();
		allLists();
	}

	public static void insertData() {

		MemberDaoTest.insertTest("김일상", "010-1234-5678", "onesang@gmail.com", "1sang@");
		MemberDaoTest.insertTest("김이상", "010-2345-6789", "twosang@gmail.com", "2sang@");

		CategoryDaoTest.insertTest("역사");
		CategoryDaoTest.insertTest("컴퓨터/IT");
		CategoryDaoTest.insertTest("과학");

		BookDaoTest.insertTest(2, "이것이 자바다", 10000);
		BookDaoTest.insertTest(1, "총 균 쇠", 15000);
		BookDaoTest.insertTest(3, "코스모스", 20000);

		CartDaoTest.insertTest(1, 2, 1);
		CartDaoTest.insertTest(1, 3, 1);

		OrderDaoTest.insertOrderTest("20200203-00001", 1, 30000, "강원도 춘천시 일상번길 1");
		OrderDaoTest.insertOrderBookTest(1, 1, 1);
		OrderDaoTest.insertOrderBookTest(1, 3, 1);

	}

	public static void allLists() {
		System.out.println("▶ 회원 리스트");
		memberList();

		System.out.println("\n▶ 카테고리 리스트");
		categoryList();

		System.out.println("\n\n▶ 도서 리스트");
		bookList();

		System.out.println("\n▶ 카트 리스트");
		cartList();

		System.out.println("\n▶ 주문 리스트");
		orderList();
	}

	public static void memberList() {
		List<MemberVo> list = new MemberDao().findAll();
		System.out.println("--------------------------------------");
		for (MemberVo vo : list) {
			System.out.println("이름 : " + vo.getName() + "\n전화번호 : " + vo.getPhone() + "\n이메일 : " + vo.getEmail()
					+ "\n비밀번호 : " + vo.getPassword());
			System.out.println("--------------------------------------");
		}
	}

	public static void categoryList() {
		List<CategoryVo> list = new CategoryDao().findAll();
		System.out.print("| ");
		for (CategoryVo vo : list) {
			System.out.print(vo.getKind() + " | ");
		}
	}

	public static void bookList() {
		List<BookVo> list = new BookDao().findAll();
		System.out.println("-----------------------------------------------------------------------");
		for (BookVo vo : list) {
			System.out.printf("카테고리 : %-5s \t제목 : %-10s\t가격 : %-10d\n", vo.getKind(), vo.getTitle(), vo.getPrice());
			System.out.println("-----------------------------------------------------------------------");
		}
	}

	public static void cartList() {
		List<CartVo> list = new CartDao().findAll();
		System.out.println("---------------------------------------------------------");
		for (CartVo vo : list) {
			System.out.println("제목 : " + vo.getTitle() + "\t\t수량 : " + vo.getAmount() + "\t가격 : " + vo.getPrice());
			System.out.println("---------------------------------------------------------");
		}
	}

	public static void orderList() {
		List<OrderVo> list = new OrderDao().selectOrder();
		System.out.println("-----------------------------------------------------------------------------------------------------");
		for (OrderVo vo : list) {
			System.out.printf("주문번호 [%-14s] \t주문자 [%-3s/%16s]   결제금액 [%5d]\n",
						vo.getOrderNo(),vo.getName(),vo.getEmail(),vo.getOrderPrice());
			System.out.println("주소 : " + vo.getAddress());
			System.out.println("-----------------------------------------------------------------------------------------------------");
		}
		List<OrderVo> bookList = new OrderDao().selectOrderBook();
		for (OrderVo vo : bookList) {
			System.out.printf("책번호 : %-2s \t제목 : %-10s\t수량 : %-2d\n", vo.getBookNo(), vo.getTitle(), vo.getQuantity());
			System.out.println("-----------------------------------------------------------------------------------------------------");
		}
	}
}
