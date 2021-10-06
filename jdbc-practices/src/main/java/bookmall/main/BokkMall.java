package bookmall.main;

public class BokkMall {

	public static void main(String[] args) {
		
		System.out.println("====회원리스트====="); //보기 좋게 printf로 구분
		
		new CategoryDao().insert(vo); //mysql평가과제 제출조건 참고하여 제출
		new CategoryDao().insert(vo); // 카테고리 리스트 3개있어야되서 예시로 3개 작성해둠
		new CategoryDao().insert(vo);  //3개 삽입
		
		new CategoryDao().findAll();  // 삽입 확인
	}

}
