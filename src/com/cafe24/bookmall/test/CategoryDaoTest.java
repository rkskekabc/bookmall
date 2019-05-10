package com.cafe24.bookmall.test;

import java.util.List;

import com.cafe24.bookmall.dao.CategoryDao;
import com.cafe24.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//insertTest("수필");
		getListTest();
	}

	private static void insertTest(String name) {
		CategoryVo vo = new CategoryVo();
		vo.setName(name);
		
		new CategoryDao().insert(vo);
	}
	
	private static void getListTest() {
		List<CategoryVo> list = new CategoryDao().getList();
		
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
}
