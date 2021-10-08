package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;


public class CartDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
	}

	private static void insertTest() {
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

	private static void findAllTest() {
		List<CartVo> list = new CartDao().findAll();
		
		for(CartVo vo: list) {
			System.out.println(vo);
		}
	}
}
