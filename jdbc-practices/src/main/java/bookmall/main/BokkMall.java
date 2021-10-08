package bookmall.main;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderDao;
import bookmall.dao.OrderbookDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderVo;
import bookmall.vo.OrderbookVo;

public class BokkMall {

	public static void main(String[] args) {
		
		Memberinsert(); //회원 2명 추가
		System.out.println("=======회원리스트======="); 
		MemberfindAll();
		
		Categoryinsert(); //카테고리 3개 추가
		System.out.println("=======카테고리 목록======="); 
		CategoryfindAll();
		
		Bookinsert(); //책 상품 3개 추가
		System.out.println("======= 상품(book) 리스트 ======="); 
		BookfindAll();
		
		Cartinsert(); //카트(장바구니) 2개 추가
		System.out.println("======= 카트(장바구니) 리스트 ======="); 
		CartfindAll();
		
		Orderinsert(); //주문 1개 추가
		System.out.println("======= 주문 리스트 ======="); 
		OrderfindAll();
		
		Orderbookinsert(); //주문 도서 리스트 2개 추가	
		System.out.println("======= 주문도서(order_book) 리스트 ======="); 
		OrderbookfindAll();
		
		
		
	}
	
	
	private static void Memberinsert() {
		MemberVo vo = null;
		MemberDao dao = new MemberDao();
		
		vo=new MemberVo();
		vo.setName("양승우");
		vo.setTel("010-1234-5678");
		vo.setEmail("abc123@naver.com");
		vo.setPassword("1234");
		dao.insert(vo);
		
		vo=new MemberVo();
		vo.setName("양아치");
		vo.setTel("010-1004-1004");
		vo.setEmail("xyz1004@naver.com");
		vo.setPassword("1004");
		dao.insert(vo);

	}

	private static void MemberfindAll() {
		List<MemberVo> list = new MemberDao().findAll();
		
		for(MemberVo vo: list) {
			System.out.println(vo);
		}
	}

	
	private static void Categoryinsert() {
		CategoryVo vo = null;
		CategoryDao dao = new CategoryDao();
		
		vo=new CategoryVo();
		vo.setName("경제경영");
		dao.insert(vo);
		
		vo=new CategoryVo();
		vo.setName("자기개발");
		dao.insert(vo);
		
		vo=new CategoryVo();
		vo.setName("컴퓨터/IT");
		dao.insert(vo);
		
	}

	private static void CategoryfindAll() {
		List<CategoryVo> list = new CategoryDao().findAll();
		
		for(CategoryVo vo: list) {
			System.out.println(vo);
		}
	}

	private static void Bookinsert() {
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

	private static void BookfindAll() {
		List<BookVo> list = new BookDao().findAll();
		
		for(BookVo vo: list) {
			System.out.println(vo);
		}
	}


	private static void Cartinsert() {
		CartVo vo = null;
		CartDao dao = new CartDao();
		
		vo=new CartVo();
		vo.setCount(5);
		vo.setBookNo(1L);
		vo.setMemberNo(1L);
		dao.insert(vo);
		
		
		vo=new CartVo();
		vo.setCount(3);
		vo.setBookNo(3L);
		vo.setMemberNo(2L);
		dao.insert(vo);
		
	}

	private static void CartfindAll() {
		List<CartVo> list = new CartDao().findAll();
		
		for(CartVo vo: list) {
			System.out.println(vo);
		}
	}
	
	
	private static void Orderinsert() {
		OrderVo vo = null;
		OrderDao dao = new OrderDao();
		
		vo=new OrderVo();
		vo.setOrderNum(1234);
		vo.setPayprice(50000);
		vo.setShipaddress("동서대학교");
		vo.setMemberNo(1L);
		dao.insert(vo);
		
	}

	private static void OrderfindAll() {
		List<OrderVo> list = new OrderDao().findAll();
		
		for(OrderVo vo: list) {
			System.out.println(vo);
		}
	}
	
	
	private static void Orderbookinsert() {
		OrderbookVo vo = null;
		OrderbookDao dao = new OrderbookDao();
		
		vo=new OrderbookVo();
		vo.setCount(3);
		vo.setBookNo(2L);
		vo.setOrderNo(1L);
		dao.insert(vo);
		
		vo=new OrderbookVo();
		vo.setCount(5);
		vo.setBookNo(3L);
		vo.setOrderNo(1L);
		dao.insert(vo);
		
	}

	private static void OrderbookfindAll() {
		List<OrderbookVo> list = new OrderbookDao().findAll();
		
		for(OrderbookVo vo: list) {
			System.out.println(vo);
		}
	}
}
