package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrderbookDao;
import bookmall.vo.OrderbookVo;


public class OrderbookDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
	}
	
	
	private static void insertTest() {
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

	private static void findAllTest() {
		List<OrderbookVo> list = new OrderbookDao().findAll();
		
		for(OrderbookVo vo: list) {
			System.out.println(vo);
		}
	}

}
