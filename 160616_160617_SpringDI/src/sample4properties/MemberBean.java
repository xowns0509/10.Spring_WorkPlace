package sample4properties;

public class MemberBean {
	private String name;
	private int age;
	private String message;
	
	// constructor
	public MemberBean(){
		System.out.println("MemberBean의 기본 생성자");
		
	}
	
	public MemberBean(String name, int age, String message){
		System.out.println("MemberBean의 인자 생성자");
		this.name = name; this.age = age; this.message = message;
		
	} //end of constructor
	
	// setter getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message  = message;
	}//end of setter getter

	
}
