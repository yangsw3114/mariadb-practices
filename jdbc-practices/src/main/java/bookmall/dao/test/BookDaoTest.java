package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;

import bookmall.vo.BookVo;


public class BookDaoTest {

	public static void main(String[] args) {
		insertTest(); 
		findAllTest();
	}

	private static void insertTest() {
		BookVo vo = null;
		BookDao dao = new BookDao();
		
		vo=new BookVo();
		vo.setTitle("부자아빠 가난한 아빠");
		vo.setPrice(15800);
		vo.setCategoryNo(1); //경제경영 카테고리
		dao.insert(vo);
		
		
		vo=new BookVo();
		vo.setTitle("할 말은 합니다");
		vo.setPrice(14400);
		vo.setCategoryNo(2); //경제경영 카테고리
		dao.insert(vo);
		
		
		vo=new BookVo();
		vo.setTitle("혼자 공부하는 파이썬");
		vo.setPrice(16200);
		vo.setCategoryNo(3); //경제경영 카테고리
		dao.insert(vo);
	}

	private static void findAllTest() {
		List<BookVo> list = new BookDao().findAll();
		
		for(BookVo vo: list) {
			System.out.println(vo);
		}
	}

}

