package book;

import java.util.List;

public interface BookService {
	
	public boolean regist(Book book);
	
	public Book read(int no);
	
	public List<Book> listAll();
	
	public boolean edit(Book book, String bookId);
	
	public boolean remove(int no);
}
