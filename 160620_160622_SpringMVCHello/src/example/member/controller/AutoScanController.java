package example.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import example.member.dto.MemberVO;

// Spring-servlet.xml에 의해 여기까지왔는데 이게 뭐하는 놈? 컨트롤러임.
// @Controller 그럼 어노테이션 줘.
@Controller
public class AutoScanController {

	// @RequestMapping(value="autoScan.do")
	// public String xxx(){

	// 원래 권장사항은 ModelAndView 객체로 리턴하는 게 룰.
	//
	// 근데 지금은 그냥 페이지만 바꿔서 출력하기를 원할 때. 커맨드Null처럼.
	// (굳이 모델앤뷰로 넘기기를 안하고 싶을 때)
	// return "autoScan";//어떤 페이지로 리턴할 것인가. autoScan 근데 이거 문자열이므로 스트링임
	// 그래서 반환형을 스트링으로
	// 이제 자동으로 /WEB-INF/view/ + autoScan + .jsp가 따라 붙겠지
	// 스트링으로 리턴하면 뷰페이지만을 지정하는 것임
	// }
	// 리턴이 스트링이라면 그냥 뷰단페이지 리턴이라고 생각하면됨.

	// @RequestMapping(value="autoScan.do")
	// public void url(){
	// 리턴도 없애기. 함수 안에 어떠한 내용도 없다면?
	// void 리턴형인 경우, 요청이름과 같은 view파일을 찾어.
	// autoScan이니 이와 똑같은 이름의 jsp파일을 찾는 다고.
	// 이렇게 함수 내 아무런 내용이 없어도 자동으로 연결시켜줘.
	// 모델 필요 없이 화면만 전환할 때.

	// }

	// @RequestMapping(value="reScan.do")
	// public String reScan() {

	// return "reScan";

	// }

	// @RequestMapping(value = "{url}.do")
	// url이 들어올 때 그냥 같은 이름의 jsp파일로 연결해주려면
	// 어노테이션에 (value="{url}.do")로 기술.
	// 이걸 작성하면 이 함수 하나로 죄다 처리 가능. 위의 함수 2개는 필요 없음.
	public void allInOne() {

	}

	// 3. 어노테이션 주입
	// @Autowired
	// @Resource(name="memVo")
	@Autowired
	private MemberVO memberVo;
	// 어떻게 주입시킬래

	// 1. 생성자 주입
	// public AutoScanController(MemberVO memberVo){
	// this.memberVo = memberVo;
	// }

	// 2. setter 주입
	// public void setMemberVO(MemberVO memberVo) {
	// this.memberVo = memberVo;
	// }

	@RequestMapping(value = "autoScan.do")
	public ModelAndView xxx() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("autoScan");
		mv.addObject("mVO", memberVo);

		return mv;
	}
	
	// 스프링에서 세션처리
	@RequestMapping(value = "{url}.do")
	public void sess(HttpSession session) {
		session.setAttribute("userId", "userId란 이름으로 세션명처리, 저장된 놈");
		session.setAttribute("IdFromMemberVoGetName", memberVo.getName());

	}

}