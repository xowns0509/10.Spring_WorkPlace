package sample3xml;

public class MemberDAO {

	private MemberBean member;
	// 생성자와 setter

	public MemberDAO() {
	}

	public MemberDAO(MemberBean member) {
		super();
		this.member = member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	public void insert() {
		System.out.println(member.getName() + member.getAge() + member.getMessage());
	}

}
