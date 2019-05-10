package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.OrdersBookVo;
import com.cafe24.bookmall.vo.OrdersVo;

public class OrdersDao {
	public Long insertOrders(OrdersVo vo) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into orders(orders_no, status, orders_price, destination, member_no) values(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getOrdersNo());
			pstmt.setString(2, vo.getStatus());
			pstmt.setInt(3, vo.getOrdersPrice());
			pstmt.setString(4, vo.getDestination());
			pstmt.setLong(5, vo.getMemberNo());
			
			pstmt.executeQuery();
			
			stmt = conn.createStatement();
			
			String getNoSql = "select last_insert_id()";
			rs = stmt.executeQuery(getNoSql);
			
			if(rs.next()) {
				return rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
 			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void insertOrdersBook(List<OrdersBookVo> voList) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into orders_book(orders_no, book_no, count) values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			for(OrdersBookVo vo : voList) {
				pstmt.setLong(1, vo.getOrdersNo());
				pstmt.setLong(2, vo.getBookNo());
				pstmt.setInt(3, vo.getCount());
				
				pstmt.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
 			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<OrdersVo> getOrdersList(){
		List<OrdersVo> result = new ArrayList<OrdersVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "select no, orders_no, status, orders_price, destination, member_no from orders";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrdersVo vo = new OrdersVo();
				vo.setNo(rs.getLong(1));
				vo.setOrdersNo(rs.getString(2));
				vo.setStatus(rs.getString(3));
				vo.setOrdersPrice(rs.getInt(4));
				vo.setDestination(rs.getString(5));
				vo.setMemberNo(rs.getLong(6));
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
 			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return result;
	}
	
	public List<OrdersBookVo> getOrdersBookList(){
		List<OrdersBookVo> result = new ArrayList<OrdersBookVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "select orders_no, book_no, count from orders_book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrdersBookVo vo = new OrdersBookVo();
				vo.setOrdersNo(rs.getLong(1));
				vo.setBookNo(rs.getLong(2));
				vo.setCount(rs.getInt(3));
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
 			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.43.19:3307/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		return conn;
	}
}
