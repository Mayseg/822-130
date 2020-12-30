package c.dao.books;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * a DAO Data Access Object class - encapsulates all JDBC CRUD (Create, Read,
 * Update, Delete) actions
 */
public class BookDaoDb implements BookDao {

	// database details
	private String url = "jdbc:mysql://localhost:3306/db1?serverTimezone=Israel&createDatabaseIfNotExist=true";
	private String user = "eldar1";
	private String password = "pass1";

	@Override
	public void save(Book book) throws DaoException {
		try (Connection con = DriverManager.getConnection(url, user, password);) {
			String sql = "insert into book values(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, book.getId()); // set the id
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setDouble(4, book.getPrice());
			pstmt.setDate(5, Date.valueOf(book.getPublication())); // convert LocalDate to java.sql.Date
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// catch an SQLException and throw a DaoException instead
			// (the SQLException is cause)
			throw new DaoException("saving book: " + book + " faild", e);
		}
	}

	@Override
	public Book get(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Book book) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) throws DaoException {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		try {
			BookDaoDb dao = new BookDaoDb();

			Book book = new Book(601, "aaa", "bbb", 150, LocalDate.of(1974, 5, 7));
			dao.save(book);

		} catch (DaoException e) {
			System.out.println(e);
			System.out.println(e.getCause());
			System.out.println("========================");
			e.printStackTrace(System.out);
		}
	}
}
