package myproj.member.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import myproj.member.dao.MemberDAO;
import myproj.member.dto.MemberVO;


@Controller
@RequestMapping("/user")
public class MemberController {
	
	//인터페이스로 주입해야지 나중에 수정했을때 편리
	@Resource(name="member")
	private MemberDAO member;
	
	
	@RequestMapping(value="/userLogin.do")
	public void userLogin(){}
	
	@RequestMapping(value="/userJoin.do")
	public void userJoin(){		
	}
	
	@RequestMapping(value="/login.do")
	public ModelAndView login(MemberVO vo, HttpSession session){
		System.out.println("로그인");
		int result = 0;
		//로그인
		MemberVO logged = member.memberLogin(vo);
		
		if(logged != null){ 
			//로그인한 유저 세션에 저장 
			session.setAttribute("sessionTime", new Date());
			session.setAttribute("userName", logged.getUserId());
			//login_ok 에서 필요햔 result 값 설정(0 이상)
			result++ ;
		}
		
		//화면으로 보내줄 값 설정
		ModelAndView mv = new ModelAndView();		
		mv.setViewName("user/login_ok");
		mv.addObject("result", result);
		mv.addObject("message", "로그인 시도");
		
		return mv;
	}
	
	@RequestMapping(value="/userInsert.do")
	public ModelAndView userInsert(MemberVO vo){
		System.out.println("입력");
		int result = member.memberInsert(vo);
		
		//화면으로 보내줄 값 설정
		ModelAndView mv = new ModelAndView();		
		mv.setViewName("user/userJoin_ok");
		mv.addObject("result", result);
		mv.addObject("message", "회원가입 시도");
		
		return mv;
	}
	
	@RequestMapping(value="/Main.do")
	public ModelAndView toMain(){
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/Main");
		
		list = member.memberList();
		if(list != null) mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping(value="/logOut.do")
	public void logout(){}
	
	@RequestMapping(value="/memberInfo.do")
	public void memberInfo(){}
	
	/**
	 * String 리턴형은 뷰단의 파일명으로 매핑 
	 * 이 경우에는 페이지를 전환하지 않는 ajax 이므로 
	 * 이런식으로 리턴이 가능함
	 * ajax 를 spring 에서 사용하고 싶을땐 
	 * @ResponseBody annotation 을 사용해야하
	 */
	@RequestMapping(value="/idCheck.do")
	@ResponseBody //비동기 통신
	public String checkId(MemberVO vo){ //userId 들어있음
		System.out.println("키 이벤트 발생");
		String result = "아이디 사용이 가능합니다";
		if(member.idCheck(vo) != null) result = "중복된 아이디 입니다"; 		
		return result;
	}
}
