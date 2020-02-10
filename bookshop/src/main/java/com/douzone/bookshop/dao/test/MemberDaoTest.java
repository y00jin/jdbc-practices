package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douozne.bookshop.dao.MemberDao;
import com.douzone.bookshop.vo.MemberVo;

public class MemberDaoTest {
	public static void main(String[] args) {
		
//		insertTest("전유진","010-7325-9876","hacer@gmail.com","1111");
//		insertTest("김일상","010-1234-5678","daily@gmail.com","2222");
		selectTest();
	}

	public static void insertTest(String name, String phone, String email, String password) {
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setPassword(password);
		new MemberDao().insert(vo);
	}

	public static void selectTest() {
		List<MemberVo> list = new MemberDao().findAll();
		for (MemberVo vo : list) {
			System.out.println(vo);
		}
	}

}
