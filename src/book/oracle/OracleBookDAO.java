package book.oracle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import book.Book;
import book.BookDAO;
import book.JDBConnection;

public class OracleBookDAO implements BookDAO {
	public int insertBook(Book book) {

		int result = 0;
		JDBConnection jdbc = new OracleJDBConnection();

		String sql = new StringBuilder().append("INSERT INTO BOOK (NO, BOOKID, TITLE, AUTHOR, PUBLISHER, PRICE, REGDATE)")
				.append("VALUES (BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)").toString();

		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			// SQL문 매개변수에 값 추가
			jdbc.pstmt.setString(1, book.getBookId());
			jdbc.pstmt.setString(2, book.getTitle());
			jdbc.pstmt.setString(3, book.getAuthor());
			jdbc.pstmt.setString(4, book.getPublisher());
			jdbc.pstmt.setInt(5, book.getPrice());

			// SQL문 실행
			result = jdbc.pstmt.executeUpdate();
			if (result > 0)
				System.out.println(result + "행이 추가되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		jdbc.close();
		return result;
	}

	public List<Book> selectAllBook() {

		List<Book> bookList = new ArrayList<>();

		JDBConnection jdbc = new OracleJDBConnection();

		// sql문 만들기

		String sql = new StringBuilder().append("SELECT *").append("  FROM BOOK").toString();

		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			// SQL문 실행
			jdbc.rs = jdbc.pstmt.executeQuery();

			while (jdbc.rs.next()) {
				bookList.add(new Book(jdbc.rs.getInt("NO"), jdbc.rs.getString("BOOKID"),jdbc.rs.getString("TITLE"), jdbc.rs.getString("AUTHOR"),jdbc.rs.getString("PUBLISHER"),
						jdbc.rs.getInt("PRICE"), jdbc.rs.getDate("REGDATE")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		jdbc.close();
		return bookList;

	}

	public Book selectBook(int no) {

		Book book = null;
		JDBConnection jdbc = new OracleJDBConnection();

		// sql문 만들기
		String sql = new StringBuilder().append("SELECT *").append("  FROM BOOK").append(" WHERE NO = ?").toString();

		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			jdbc.pstmt.setInt(1, no);
			// SQL문 실행
			jdbc.rs = jdbc.pstmt.executeQuery();

			if (jdbc.rs.next()) {
				book =new Book(jdbc.rs.getInt("NO"), jdbc.rs.getString("BOOKID"),jdbc.rs.getString("TITLE"), jdbc.rs.getString("AUTHOR"),jdbc.rs.getString("PUBLISHER"),
						jdbc.rs.getInt("PRICE"), jdbc.rs.getDate("REGDATE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		jdbc.close();
		return book;
	}

	public int updateBook(Book book) {

		int result = 0;
		JDBConnection jdbc = new OracleJDBConnection();

		String sql = new StringBuilder().append("UPDATE BOOK").append("   SET TITLE = ?, AUTHOR = ?, PUBLISHER = ?, PRICE = ?")
				.append(" WHERE NO = ?").toString();

		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			jdbc.pstmt.setString(1, book.getTitle());
			jdbc.pstmt.setString(2, book.getAuthor());
			jdbc.pstmt.setString(3, book.getPublisher());
			jdbc.pstmt.setInt(3, book.getPrice());
			jdbc.pstmt.setInt(5, book.getNo());

			// SQL문 실행
			result = jdbc.pstmt.executeUpdate();
			if (result > 0)
				System.out.println(result + "행이 수정되었습니다.");
			else
				System.out.println("해당하는 행을 찾을 수 없습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		jdbc.close();
		return result;
	}

	public int deleteBook(int no) {

		int result = 0;
		JDBConnection jdbc = new OracleJDBConnection();

		String sql = new StringBuilder().append("DELETE BOOK").append(" WHERE NO = ?").toString();

		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			jdbc.pstmt.setInt(1, no);

			result = jdbc.pstmt.executeUpdate();
			if (result > 0)
				System.out.println(result + "행이 삭제되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		jdbc.close();
		return result;
	}
}
