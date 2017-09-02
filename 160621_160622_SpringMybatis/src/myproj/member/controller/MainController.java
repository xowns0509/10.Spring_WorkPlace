package myproj.member.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import myproj.member.dao.MemberDAOImpl;
import myproj.member.dto.MemberVO;

// Spring-servlet.xml에 의해 여기까지왔는데 이게 뭐하는 놈? 컨트롤러임.
// @Controller 그럼 어노테이션 줘.
@Controller
//@RestController// 서블렛에서 RequestMappingHandlerAdapter를 사용 할 때
public class MainController {

	@RequestMapping(value = "/user/userLogin.do")
	public void userLogin() {

	}

	@RequestMapping(value = "/user/userJoin.do")
	public void userJoin() {

	}

	@Resource(name = "daoId")
	private MemberDAOImpl dao;

	@RequestMapping(value = "/user/userInsert.do")
	public ModelAndView userInsert(MemberVO vo) {

		int result = dao.memberInsert(vo);

		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);

		if (result == 1) {
			mv.addObject("message", "가입성공!");
		} else {
			mv.addObject("message", "가입실패했습니다!");
		}

		mv.setViewName("/user/userJoin_ok");

		return mv;
	}

	// 로그인하기
	@RequestMapping(value = "/user/login.do")
	public ModelAndView login(MemberVO vo, HttpSession sess) {

		MemberVO voResult = dao.memberLogin(vo);

		ModelAndView mv = new ModelAndView();

		if (voResult != null) {
			mv.addObject("message", "로그인 성공!");
			mv.addObject("result", 1);

			sess.setAttribute("userName", voResult.getUserId());
			sess.setAttribute("sessionTime", new Date());
			sess.setAttribute("userId", voResult.getUserId());
			// sess.setAttribute("userName", voResult.getUserName());
			sess.setAttribute("userPass", voResult.getUserPass());
			// mv.addObject("vo",vo);
		} else {
			mv.addObject("message", "로그인 실패했습니다!");
			mv.addObject("result", 0);
		}

		mv.setViewName("/user/login_ok");

		return mv;
	}

	// @RequestMapping(value = "/user/Main.do")
	public ModelAndView Main(HttpSession sess) {

		ModelAndView mv = new ModelAndView();

		MemberVO vo = new MemberVO();

		vo.setUserId(String.valueOf(sess.getAttribute("userId")));
		vo.setUserName(String.valueOf(sess.getAttribute("userName")));
		vo.setUserPass(String.valueOf(sess.getAttribute("userPass")));

		// List<MemberVO> list = new List<MemberVO>();
		// Cannot instantiate the type List<Product>
		List<MemberVO> list = new ArrayList<MemberVO>();

		list.add(vo);

		mv.addObject("userName", String.valueOf(sess.getAttribute("userName")));
		// mv.addObject("list", list);
		mv.setViewName("/user/Main");
		return mv;
	}

	// 아이디체크 >> js의 AJAX에 의해 불려지는 메소드
	@RequestMapping(value = "user/idCheck.do")
	@ResponseBody
	// 이걸 쓰면 이 메소드는 화면 전환 말고 비동기 통신해야 한다고 설정
	// 이 후 xml로 이동
	public String checkId(MemberVO vo) {// MemberVO 대신 String userId로 받아도 됨.

		System.out.println("키 이벤트 발생");
		
		String result = "아이디 사용가능";

		if (dao.idCheck(vo) != null) {

			result = "중복된 아이디 입니다";

		}
		return result;//>>이걸 AJAX로 보내야 해. 그짓을 하려면
		// @ResponseBody를 추가해줘야 함

		// MemberDAO를 상속받은 MemberDAOImpl말고 MemberDAO를 쓰는 이유가
		// MemberDAO 인터페이스로 설정하고 수정을 덜 할려고

	}

	@RequestMapping(value = "user/{url}.do")
	public void test() {
		System.out.println("user/{url}.do");

	}

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
	// public void allInOne() {
	//
	// }

	// 3. 어노테이션 주입
	// @Autowired
	// @Resource(name="memVo")
	// @Autowired
	// private MemberVO memberVo;
	// 어떻게 주입시킬래

	// 1. 생성자 주입
	// public AutoScanController(MemberVO memberVo){
	// this.memberVo = memberVo;
	// }

	// 2. setter 주입
	// public void setMemberVO(MemberVO memberVo) {
	// this.memberVo = memberVo;
	// }

	// @RequestMapping(value = "autoScan.do")
	// public ModelAndView xxx() {
	// ModelAndView mv = new ModelAndView();
	// mv.setViewName("autoScan");
	// mv.addObject("mVO", memberVo);
	//
	// return mv;
	// }

	// 스프링에서 세션처리
	// @RequestMapping(value = "{url}.do")
	// public void sess(HttpSession session) {
	// session.setAttribute("userId", "userId란 이름으로 세션명처리, 저장된 놈");
	// session.setAttribute("IdFromMemberVoGetName", memberVo.getName());
	//
	// }

}