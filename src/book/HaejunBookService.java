package book;

import java.util.List;

public class HaejunBookService implements BookService {

	private BookDAO bookDao;

	public HaejunBookService(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	public boolean regist(Book book) {
		return 1 == bookDao.insertBook(book);
	}

	public Book read(int no) {
		return bookDao.selectBook(no);
	}

	public List<Book> listAll() {
		return bookDao.selectAllBook();
	}

	public boolean edit(Book book, String bookId) {
		if (book == null)
			return false;
		if (bookId == null)
			return false;

		Book BookInfo = bookDao.selectBook(book.getNo());
		if (bookId.equals(BookInfo.getBookId()))
			return 1 == bookDao.updateBook(book);
		else
			return false;
	}

	public boolean remove(int no) {
		if (bookDao.selectBook(no) == null)
			return false;
		return 1 == bookDao.deleteBook(no);
	}
}
