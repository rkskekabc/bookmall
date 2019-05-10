package com.cafe24.bookmall.main;

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
		showCartList(1L);
		showOrdersList(1L);
		showOrdersBookList(1L);

//		putCart(1L, 1L, 2);
//		showCartList(1L);
//		doOrder(1L, "목적지1");
//		showOrdersList();
//		showOrdersBookList();
	}
	
//	private static void putCart(Long memberNo, Long bookNo, int count) {
//		CartVo vo = new CartVo();
//		vo.setMemberNo(memberNo);
//		vo.setBookNo(bookNo);
//		vo.setCount(count);
//		
//		new CartDao().insert(vo);
//	}
//	
//	private static void doOrder(Long memberNo, String destination) {
//		List<CartVo> cartList = new CartDao().getList(memberNo);
//		if(cartList.size() > 0) {
//			OrdersDao ordersDao = new OrdersDao();
//			OrdersVo ordersVo = new OrdersVo();
//			List<OrdersBookVo> ordersBookList = new ArrayList<OrdersBookVo>();
//			
//			int ordersPrice = 0;
//			for(CartVo vo : cartList) {
//				ordersPrice += vo.getPrice();
//				
//				OrdersBookVo ordersBookVo = new OrdersBookVo();
//				ordersBookVo.setBookNo(vo.getBookNo());
//				ordersBookVo.setCount(vo.getCount());
//				ordersBookList.add(ordersBookVo);
//			}
//			
//			ordersVo.setOrdersNo("20190509-0001");
//			ordersVo.setStatus("주문대기");
//			ordersVo.setOrdersPrice(ordersPrice);
//			ordersVo.setDestination(destination);
//			ordersVo.setMemberNo(memberNo);
//			
//			Long ordersNo = ordersDao.insertOrders(ordersVo);
//			
//			for(OrdersBookVo vo : ordersBookList) {
//				vo.setOrdersNo(ordersNo);
//			}
//			ordersDao.insertOrdersBook(ordersBookList);
//		}
//	}

	private static void showMemberList() {
		List<MemberVo> list = new MemberDao().getList();
		
		System.out.println("---------회원목록---------");
		for(MemberVo vo : list) {
			System.out.println("회원명 : " + vo.getName() + "\t전화번호 : " + vo.getPhone() + "\t이메일 : " + vo.getEmail());
		}
		System.out.println();
	}
	
	private static void showCategoryList() {
		List<CategoryVo> list = new CategoryDao().getList();

		System.out.println("---------카테고리목록---------");
		for(CategoryVo vo : list) {
			System.out.println("카테고리명 : " + vo.getName());
		}
		System.out.println();
	}
	
	private static void showBookList() {
		List<BookVo> list = new BookDao().getList();

		System.out.println("---------책목록---------");
		for(BookVo vo : list) {
			System.out.println("제목 : " + vo.getName() + "\t가격 : " + vo.getPrice() + "\t카테고리 : " + vo.getCategoryName());
		}
		System.out.println();
	}
	
	private static void showCartList(Long memberNo) {
		List<CartVo> list = new CartDao().getList(memberNo);

		System.out.println("---------카트 목록---------");
		for(CartVo vo : list) {
			System.out.println("회원명 : " + vo.getMemberName() + "\t책이름 : " + vo.getBookName() + "\t수량 : " + vo.getCount() + "\t가격 : " + vo.getPrice());
		}
		System.out.println();
	}
	
	private static void showOrdersList(Long memberNo) {
		List<OrdersVo> list = new OrdersDao().getOrdersList(memberNo);

		System.out.println("---------주문 목록---------");
		for(OrdersVo vo : list) {
			System.out.println("회원명 : " + vo.getMemberName() + "\t주문번호 : " + vo.getOrdersNo() + "\t주문상태 : " + vo.getStatus() + "\t가격 : " + vo.getOrdersPrice() + "\t목적지 : " + vo.getDestination());
		}
		System.out.println();
	}
	
	private static void showOrdersBookList(Long ordersNo) {
		List<OrdersBookVo> list = new OrdersDao().getOrdersBookList(ordersNo);

		System.out.println("---------주문도서 목록---------");
		for(OrdersBookVo vo : list) {
			System.out.println("주문번호 : " + vo.getOrdersName() + "\t책이름 : " + vo.getBookName() + "\t수량 : " + vo.getCount() + "\t가격 : " + vo.getPrice());
		}
		System.out.println();
	}
}
