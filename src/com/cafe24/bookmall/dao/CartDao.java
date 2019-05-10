package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.vo.CartVo;

public class CartDao {
	public void insert(CartVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into cart(member_no, book_no, count) values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getMemberNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setInt(3, vo.getCount());
			
			pstmt.executeQuery();
			
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
	
	public List<CartVo> getList(Long memberNo){
		List<CartVo> result = new ArrayList<CartVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "select b.name, c.name, a.count, a.count * c.price from cart a"
							+ " join member b on a.member_no = b.no"
							+ " join book c on a.book_no = c.no"
							+ " where member_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CartVo vo = new CartVo();
				vo.setMemberName(rs.getString(1));
				vo.setBookName(rs.getString(2));
				vo.setCount(rs.getInt(3));
				vo.setPrice(rs.getInt(4));
				
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
