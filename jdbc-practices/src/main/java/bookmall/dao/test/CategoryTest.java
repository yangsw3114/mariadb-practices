package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
	}


	private static void insertTest() {
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

	
	private static void findAllTest() {
		List<CategoryVo> list = new CategoryDao().findAll();
		
		for(CategoryVo vo: list) {
			System.out.println(vo);
		}
	}

}
