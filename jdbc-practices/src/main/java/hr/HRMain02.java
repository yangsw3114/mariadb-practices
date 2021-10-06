package hr;

import java.util.List;
import java.util.Scanner;

public class HRMain02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("salary[min max] > "); //월급 최소 최대 설정하여 그 사이값 나열
		int minSalary = scanner.nextInt();
		int maxSalary = scanner.nextInt();
		

		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVo> result = dao.findBySalary(minSalary, maxSalary);
		
		for(EmployeeVo vo : result) {
			System.out.println(vo.getNo() + ":" + vo.getFirstName() +"  "+ vo.getLastName() +"  "+ vo.getSalary());
			
		}
		
		scanner.close();
	}

}
