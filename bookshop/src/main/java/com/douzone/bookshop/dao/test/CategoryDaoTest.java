package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douozne.bookshop.dao.CategoryDao;
import com.douzone.bookshop.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		
//		insertTest("역사");
//		insertTest("컴퓨터/IT");
		selectTest();
	}
	
	public static void insertTest(String kind) {
		CategoryVo vo = new CategoryVo();
		vo.setKind(kind);
		new CategoryDao().insert(vo);
	}
	
	public static void selectTest() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
	}

}
