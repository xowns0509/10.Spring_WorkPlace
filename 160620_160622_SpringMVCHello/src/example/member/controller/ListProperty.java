package example.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import example.member.dto.MemberVO;
import example.member.dto.MemberVOList;

@Controller
public class ListProperty {

	@RequestMapping("multiInsert.do")
	public void multiInsert(MemberVOList memberList) {
		// MemberVOList memberList
		System.out.println("multiInsert 요청됨.");
		for (MemberVO vo : memberList.getList()) {
			System.out.println("<" + vo.isState() + ">" + vo.getId() + ":" + vo.getName() + "/" + vo.getAge());

		}

		// 뷰단(jstl) 만들고 내용을 출력
	}

}
