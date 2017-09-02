package example.member.dto;

import java.util.List;

public class MemberVOList {
	private List<MemberVO> list; //멤버 여러 개 저장하기 위해

	public List<MemberVO> getList() {
		return list;
	}

	public void setList(List<MemberVO> list) {
		this.list = list;
	}
	
	
}
