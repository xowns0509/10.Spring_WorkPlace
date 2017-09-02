package example.member.dto;

public class MemberVO {
	private String id;
	private String name;
	private int age;
	private boolean state;//상태를 주기 위해 하나 더 추가.
	
	//불린형은 get이 아니라 is로!!!
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public MemberVO(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	
}
