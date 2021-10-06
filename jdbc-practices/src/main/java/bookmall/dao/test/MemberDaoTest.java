package bookmall.dao.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;



public class MemberDaoTest {

	public static void main(String[] args) {
		insertTest(); 
		findAllTest();
	}

	private static void insertTest() {
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

	private static void findAllTest() {
		List<MemberVo> list = new MemberDao().findAll();
		
		for(MemberVo vo: list) {
			System.out.println(vo);
		}
	}

}
