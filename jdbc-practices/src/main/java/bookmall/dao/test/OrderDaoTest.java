package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.OrderDao;
import bookmall.dao.OrderbookDao;
import bookmall.vo.BookVo;
import bookmall.vo.OrderVo;
import bookmall.vo.OrderbookVo;



public class OrderDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
	}
	
	
	
	private static void insertTest() {
		OrderVo vo = null;
		OrderDao dao = new OrderDao();

		
		vo=new OrderVo();
		vo.setOrderNum(1234);
		vo.setPayprice(50000);
		vo.setShipaddress("동서대학교");
		vo.setMemberNo(1L);
		dao.insert(vo);
	}

	private static void findAllTest() {
		List<OrderVo> list = new OrderDao().findAll();
		
		for(OrderVo vo: list) {
			System.out.println(vo);
		}
	}

}
