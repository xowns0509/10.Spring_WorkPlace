package sample5collection;

import java.util.List;

public class ListBean {
	private List<Integer> intlist;
	private List<MemberBean> memberList;

	// 생성자
	public ListBean() {

	}

	// setter
	public List<Integer> getIntList() {
		return intlist;
	}

	public void setIntList(List<Integer> list) {
		this.intlist = list;
	}

	public List<MemberBean> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<MemberBean> memberList) {
		this.memberList = memberList;
	}

}
