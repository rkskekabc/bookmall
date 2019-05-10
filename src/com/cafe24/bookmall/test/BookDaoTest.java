package com.cafe24.bookmall.test;

import java.util.List;

import com.cafe24.bookmall.dao.BookDao;
import com.cafe24.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		//insertTest("인연", 20000, 2L);
		getBookTest(2L);
		getListTest();
	}

	private static void insertTest(String name, int price, Long categoryNo) {
		BookVo vo = new BookVo();
		vo.setName(name);
		vo.setPrice(price);
		vo.setCategoryNo(categoryNo);
		
		new BookDao().insert(vo);
	}
	
	private static void getBookTest(Long bookNo) {
		System.out.println(new BookDao().getBook(bookNo));
	}
	
	private static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
}
