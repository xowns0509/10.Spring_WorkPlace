package springMVC.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//이놈이 컨트롤러 역할을 하기 위해
@Controller
public class HelloController {

	// start()함수명은 의미가 없음. 하지만 우리가 헷갈리므로 이름을 통일했음.
	@RequestMapping("/start.do")
	public ModelAndView start() {
		// 리턴형으로 ModelAndView형 하나로 통합

		System.out.println("start.do 요청처리: 추후 모델과 DB연동까지 가능.");
		// ModelAndView mv = new ModelAndView();
		// 모델과 뷰를 같이 결정하는 놈
		// mv.addObject("message", "조별활동 열심히");

		//mv.setViewName("/view/hello.jsp");// .jsp를 지워도 hello.jsp가 자동으로 불림. 
		//mv.setViewName("/view/hello");// .jsp를 지워도 hello.jsp가 자동으로 불림. 
		//mv.setViewName("hello");// common-servlet.xml에 value="/WEB-INF/view/"를 추가 후.
		
		return new ModelAndView("hello", "message", "조별활동 열심히");
		// 하나일 때만 이렇게 가능. 아래처럼 2개 이상을 넣으려면 못해.

	}
	
	@RequestMapping("/a.do")
	public ModelAndView a() {

		System.out.println("a.do 요청처리: 추가한 놈.");
		ModelAndView mv = new ModelAndView();
		// 모델과 뷰를 같이 결정하는 놈
		mv.addObject("id", "아이디 자리");
		mv.addObject("msg", "메시지 자리");

		//mv.setViewName("/view/hello.jsp");// .jsp를 지워도 hello.jsp가 자동으로 불림. 
		//mv.setViewName("/view/hello");// .jsp를 지워도 hello.jsp가 자동으로 불림. 
		
		mv.setViewName("hello2");// common-servlet.xml에 value="/WEB-INF/view/"를 추가 후.

		return mv;

	}

}
