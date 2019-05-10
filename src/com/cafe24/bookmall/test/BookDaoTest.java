package com.cafe24.bookmall.test;

import java.util.List;

import com.cafe24.bookmall.dao.BookDao;
import com.cafe24.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		insertTest("운수좋은날", 15000, 1L);
		insertTest("인연", 20000, 2L);
		insertTest("대규모 서비스를 지탱하는 기술", 25000, 3L);
		//getBookTest(2L);
		getListTest();
	}

	private static void insertTest(String name, int price, Long categoryNo) {
		BookVo vo = new BookVo();
		vo.setName(name);
		vo.setPrice(price);
		vo.setCategoryNo(categoryNo);
		
		new BookDao().insert(vo);
	}
	
//	private static void getBookTest(Long bookNo) {
//		System.out.println(new BookDao().getBook(bookNo));
//	}
	
	private static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
}
