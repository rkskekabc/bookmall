package com.cafe24.bookmall.test;

import java.util.List;

import com.cafe24.bookmall.dao.CartDao;
import com.cafe24.bookmall.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {
		insertTest(1L, 1L, 2);
		insertTest(1L, 2L, 3);
		getListTest(1L);
	}
	
	private static void insertTest(Long memberNo, Long bookNo, int count) {
		CartVo vo = new CartVo();
		vo.setMemberNo(memberNo);
		vo.setBookNo(bookNo);
		vo.setCount(count);
		
		new CartDao().insert(vo);
	}
	
	private static void getListTest(Long memberNo) {
		List<CartVo> list = new CartDao().getList(memberNo);
		
		for(CartVo vo : list) {
			System.out.println(vo);
		}
	}
}
