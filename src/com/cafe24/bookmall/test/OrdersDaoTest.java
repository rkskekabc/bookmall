package com.cafe24.bookmall.test;

import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.dao.OrdersDao;
import com.cafe24.bookmall.vo.OrdersBookVo;
import com.cafe24.bookmall.vo.OrdersVo;

public class OrdersDaoTest {
	public static void main(String[] args) {
		insertOrdersTest("20090509-0001", "주문대기", 90000, "인천", 1L);
		insertOrdersBookTest(1L, 1L, 2);
		insertOrdersBookTest(1L, 2L, 3);
		getOrdersListTest(1L);
		getOrdersBookListTest(1L);
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
		voList.add(vo);
		
		new OrdersDao().insertOrdersBook(voList);
	}
	
	private static void getOrdersListTest(Long memberNo) {
		List<OrdersVo> list = new OrdersDao().getOrdersList(memberNo);
		
		for(OrdersVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void getOrdersBookListTest(Long ordersNo) {
		List<OrdersBookVo> list = new OrdersDao().getOrdersBookList(ordersNo);
		
		for(OrdersBookVo vo : list) {
			System.out.println(vo);
		}
	}
}
