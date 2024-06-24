package test; 

import java.util.List;

import book.Book;
import book.HaejunBookService;
import book.oracle.OracleBookDAO;

public class BookManagerTest {

	public static void main(String[] args) {
		HaejunBookService service = new HaejunBookService(new OracleBookDAO());
		
//		책 정보 모두 보기
		List<Book> bookList = service.listAll();
		for(Book book : bookList) {
			System.out.println(book.toString());
		}
		
//		책 정보 보기		
		Book book = service.read(2);
		if(book != null) {
			System.out.println(book.toString());
		}
		
//		책 추가
//		Book book = new Book("E3I94RU8", "해리 포터와 마법사의 돌", "j.k. 롤링", "문학동네", 15000);
//		Book book = new Book("Y6U8T5I9", "1984", "조지 오웰", "민음사", 13000);
//		Book book = new Book("U7O07UR4", "작은 아씨들", "루이자 메이 올콧", "을유문화사", 12000);
//		Book book = new Book("T57U2WE3", "호밀밭의 파수꾼", "J.D. 샐린저", "민음사", 14000);

//		if(service.regist(book))
//			System.out.println("책 등록을 성공하였습니다.");
//		else
//			System.out.println("책 등록을 실패하였습니다.");
		
//		책 정보 수정
//	    book = new Book(4, null, "수정될 제목", "수정될 저자", "수정될 출판사", 13500, null);
//		service.edit(book, "T57U2WE3");
		
//		책 삭제 
//		service.remove(2);
	}

}
