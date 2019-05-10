package com.cafe24.bookmall.test;

import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.dao.OrdersDao;
import com.cafe24.bookmall.vo.OrdersBookVo;
import com.cafe24.bookmall.vo.OrdersVo;

public class OrdersDaoTest {
	public static void main(String[] args) {
		//insertOrdersTest("20090509-0002", "주문대기", 30000, "목적지2", 2L);
		//insertOrdersBookTest(2L, 1L, 2);
		getOrdersListTest();
		getOrdersBookListTest();
	}
	
	private static void insertOrdersTest(String ordersNo, String status, int ordersPrice, String destination, Long memberNo) {
		OrdersVo vo = new OrdersVo();
		vo.setOrdersNo(ordersNo);
		vo.setStatus(status);
		vo.setOrdersPrice(ordersPrice);
		vo.setDestination(destination);
		vo.setMemberNo(memberNo);
		
		new OrdersDao().insertOrders(vo);
	}
	
	private static void insertOrdersBookTest(Long ordersNo, Long bookNo, int count) {
		List<OrdersBookVo> voList = new ArrayList<OrdersBookVo>();
		
		OrdersBookVo vo = new OrdersBookVo();
		vo.setOrdersNo(ordersNo);
		vo.setBookNo(bookNo);
		vo.setCount(count);
		
		new OrdersDao().insertOrdersBook(voList);
	}
	
	private static void getOrdersListTest() {
		List<OrdersVo> list = new OrdersDao().getOrdersList();
		
		for(OrdersVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void getOrdersBookListTest() {
		List<OrdersBookVo> list = new OrdersDao().getOrdersBookList();
		
		for(OrdersBookVo vo : list) {
			System.out.println(vo);
		}
	}
}
