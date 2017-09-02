package aop3_annotation.order;

public class MemberServiceImpl implements MemberService {

	@Override
	public void register() {
		System.out.println("register 호출");
		// TODO Auto-generated method stub

	}

	@Override
	public boolean update(String memberId) {
		System.out.println("update() 호출" + memberId);
		// TODO Auto-generated method stub
		return false;
	}

}
