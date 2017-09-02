package example.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.member.dto.MemberVO;

@Controller
// /re없앨려면 클래스 앞에다가 아래 기술
@RequestMapping("/test")
public class RequestMappingController2 {

	//@RequestMapping(value = "/param.do")
	//public void request() {
	//	System.out.println("/test/param.do?id=hong&age=33의 요청이 왔어.");
	//}
	
	@RequestMapping(value = "/param.do")
	public void test(MemberVO mvo) {
		// 파라메터명과 mvo의 프로퍼티명이 맞으니
		// 이것도 가능하다
	}

}
