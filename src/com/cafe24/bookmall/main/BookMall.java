package com.cafe24.bookmall.main;

import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.dao.BookDao;
import com.cafe24.bookmall.dao.CartDao;
import com.cafe24.bookmall.dao.CategoryDao;
import com.cafe24.bookmall.dao.MemberDao;
import com.cafe24.bookmall.dao.OrdersDao;
import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.CartVo;
import com.cafe24.bookmall.vo.CategoryVo;
import com.cafe24.bookmall.vo.MemberVo;
import com.cafe24.bookmall.vo.OrdersBookVo;
import com.cafe24.bookmall.vo.OrdersVo;

public class BookMall {

	public static void main(String[] args) {
		showMemberList();
		showCategoryList();
		showBookList();
		putCart(2L, 1L, 2);
		showCartList(1L);
		showCartList(2L);
		showOrdersList();
		showOrdersBookList();
		
//		showCartList(1L);
//		doOrder(1L, "목적지1");
//		showOrdersList();
//		showOrdersBookList();
	}
	
	private static void putCart(Long memberNo, Long bookNo, int count) {
		CartVo vo = new CartVo();
		vo.setMemberNo(memberNo);
		vo.setBookNo(bookNo);
		vo.setCount(count);
		
		new CartDao().insert(vo);
	}
	
	private static void doOrder(Long memberNo, String destination) {
		List<CartVo> cartList = new CartDao().getList(memberNo);
		if(cartList.size() > 0) {
			OrdersDao ordersDao = new OrdersDao();
			OrdersVo ordersVo = new OrdersVo();
			List<OrdersBookVo> ordersBookList = new ArrayList<OrdersBookVo>();
			
			int ordersPrice = 0;
			for(CartVo vo : cartList) {
				ordersPrice += vo.getPrice();
				
				OrdersBookVo ordersBookVo = new OrdersBookVo();
				ordersBookVo.setBookNo(vo.getBookNo());
				ordersBookVo.setCount(vo.getCount());
				ordersBookList.add(ordersBookVo);
			}
			
			ordersVo.setOrdersNo("20190509-0001");
			ordersVo.setStatus("주문대기");
			ordersVo.setOrdersPrice(ordersPrice);
			ordersVo.setDestination(destination);
			ordersVo.setMemberNo(memberNo);
			
			Long ordersNo = ordersDao.insertOrders(ordersVo);
			
			for(OrdersBookVo vo : ordersBookList) {
				vo.setOrdersNo(ordersNo);
			}
			ordersDao.insertOrdersBook(ordersBookList);
		}
	}

	private static void showMemberList() {
		List<MemberVo> list = new MemberDao().getList();
		
		for(MemberVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void showCategoryList() {
		List<CategoryVo> list = new CategoryDao().getList();
		
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void showBookList() {
		List<BookVo> list = new BookDao().getList();
		
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void showCartList(Long memberNo) {
		List<CartVo> list = new CartDao().getList(memberNo);
		
		for(CartVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void showOrdersList() {
		List<OrdersVo> list = new OrdersDao().getOrdersList();
		
		for(OrdersVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void showOrdersBookList() {
		List<OrdersBookVo> list = new OrdersDao().getOrdersBookList();
		
		for(OrdersBookVo vo : list) {
			System.out.println(vo);
		}
	}
}
