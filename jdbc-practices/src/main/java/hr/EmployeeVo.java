package hr;

public class EmployeeVo { //VO는 데이터 교환을 위한 걕체, 속성과 그 속성에 접근하기 위한 클래스
	private Long no;
	private String birthDate;
	private String firstName;
	private String lastName;
	private String gender;
	private String hire_Date;
	
	private int salary;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHire_Date() {
		return hire_Date;
	}

	public void setHire_Date(String hire_Date) {
		this.hire_Date = hire_Date;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeVo [no=" + no + ", birthDate=" + birthDate + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", hire_Date=" + hire_Date + ", salary=" + salary + "]";
	}
	
	
}
