package book;

import java.sql.Date;

public class Book {

	private int no;
	private String bookId;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private Date regdate;

	public Book(int no, String bookId, String title, String author, String publisher, int price, Date regdate) {
		this.no = no;
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.regdate = regdate;
	}
	
	public Book(String bookId, String title, String author, String publisher, int price) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Book [no=" + no + ", bookId=" + bookId + ", title=" + title + ", author=" + author + ", publisher="
				+ publisher + ", price=" + price + ", regdate=" + regdate + "]";
	}

}
