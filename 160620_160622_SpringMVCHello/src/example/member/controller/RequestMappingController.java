package example.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.member.dto.MemberVO;

@Controller
// /re없앨려면 클래스 앞에다가 아래 기술
@RequestMapping("/re")
public class RequestMappingController {

	@RequestMapping(value = { "/a.do", "/b.do" })
	// @RequestMapping(value = { "/re/a.do", "/re/b.do" })
	// 2개 이상은 물결괄호
	public String test() {
		System.out.println("a.do, b.do의 요청이 왔어.");
		return "hello";// hello.jsp
	}

	@RequestMapping(value = "/c.do", params = { "id=kim" })
	// 파라메터가 없을 때는 안 들어오게 하고 싶어.
	// 그럼 params={"id=kim"}추가
	// 이러면 파라메터가 없을 때는 404 뜸.
	public void xxx() {
		System.out.println("c.do의 요청이 왔어.");

	}

	@RequestMapping(value = "/request.do", method=RequestMethod.POST)
	// 근데 post방식일 때만 받아낼려면? method=RequestMethod.POST 추가.
	// HTTP Status 405 - Request method 'GET' not supported 가 뜸.
	public void request(@ModelAttribute("srs") MemberVO vo) {// 이렇게 한 것만으로도 자동으로 들어가
		
		// 이전화면의 입력값을 얻어와야 하지.
		// 모델의 멤버필드로 지정해야 함
		// String id = request.getParameter("id");
		// MemberVO mvo = new MemberVO();
		// mvo.set..getClass().
		
		// vo로는 왜 못불러 올까.
		// vo라는 변수명은 이 메소드 안에서만 사용이 가능하지
		// 근데 스프링은 어떻게 객체를 잡냐면
		// 자동으로 클래스명의 첫글자를 소문자로 바꾸고 객체를 생성
		// 그러니까 
		
		// 굳이 memberVO가 아닌 다른 객체명으로 갖고 오고 싶다면
		//  MemberVO vo 앞에 @ModelAttribute("원하는 객체명")를 앞에 삽입 
		// 그럼 아까 자동으로 만들어 준 memberVO로는 못갖고오겠지

	}

}
