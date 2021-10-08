package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;



public class OrderDaoTest {

	public static void main(String[] args) {
		System.out.println("에러1");
		insertTest();
		System.out.println("에러2");
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
