package com.douozne.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.OrderVo;

public class OrderDao {
	public OrderVo find(Long no) {
		return null;
	}

	public boolean insertOrder(OrderVo orderVo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into order_history values(null,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, orderVo.getOrderNo());
			pstmt.setInt(2, orderVo.getMemberNo());
			pstmt.setInt(3, orderVo.getOrderPrice());
			pstmt.setString(4, orderVo.getAddress());
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

	public boolean insertOrderBook(OrderVo orderVo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into order_book values(?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, orderVo.getOrderBookNo());
			pstmt.setInt(2, orderVo.getBookNo());
			pstmt.setInt(3, orderVo.getQuantity());
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

	public List<OrderVo> selectOrder() {
		List<OrderVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select a.no,a.order_num,a.member_no,a.order_price,a.address, b.name, b.email \r\n"
					+ "from order_history a, member b\r\n" + "where a.member_no = b.no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt(1);
				String orderNo = rs.getString(2);
				int memberNo = rs.getInt(3);
				int orderPrice = rs.getInt(4);
				String address = rs.getString(5);
				String name = rs.getString(6);
				String email = rs.getString(7);

				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setOrderNo(orderNo);
				vo.setMemberNo(memberNo);
				vo.setOrderPrice(orderPrice);
				vo.setAddress(address);
				vo.setName(name);
				vo.setEmail(email);
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

	public List<OrderVo> selectOrderBook() {
		List<OrderVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select b.no, b.title, a.quantity\r\n" + "from order_book a, book b, order_history c\r\n"
					+ "where a.book_no = b.no\r\n" + "and a.order_no = c.no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int bookNo = rs.getInt(1);
				String title = rs.getString(2);
				int quantity = rs.getInt(3);

				OrderVo vo = new OrderVo();
				vo.setBookNo(bookNo);
				vo.setTitle(title);
				vo.setQuantity(quantity);
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
