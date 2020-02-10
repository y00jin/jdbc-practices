package com.douozne.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.CartVo;

public class CartDao {
	public CartVo find(Long no) {
		return null;
	}

	public boolean insert(CartVo cartVo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into cart values((select no from member where no = ?),(select no from book where no = ?),?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cartVo.getMemberNo());
			pstmt.setInt(2, cartVo.getBookNo());
			pstmt.setInt(3, cartVo.getAmount());
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<CartVo> findAll() {
		List<CartVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select a.member_no, a.book_no, b.title, a.amount, b.price\r\n"
					+ "from cart a, book b, member c\r\n" + "where a.book_no = b.no\r\n" + "and a.member_no = c.no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int memberNo = rs.getInt(1);
				int bookNo = rs.getInt(2);
				String title = rs.getString(3);
				int amount = rs.getInt(4);
				int price = rs.getInt(5);

				CartVo vo = new CartVo();
				vo.setMemberNo(memberNo);
				vo.setBookNo(bookNo);
				vo.setTitle(title);
				vo.setAmount(amount);
				vo.setPrice(price);
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/bookshop";
			conn = DriverManager.getConnection(url, "bookshop", "bookshop");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		}
		return conn;
	}
}
