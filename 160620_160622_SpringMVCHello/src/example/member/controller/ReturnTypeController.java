package example.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReturnTypeController {

	@RequestMapping(value = "model.do")
	public void test(Model m) {
		// 모델은 소속이 스프링이라
		m.addAttribute("name", "모델의 name");
		m.addAttribute("message", "행운이 깃드는 날");

		// 리턴형 void라 model.jsp로 가겠지.
	
		System.out.println("test 실행");

	}

	@RequestMapping(value = "map.do")
	public Map<String, String> test2() {

		Map<String, String> map = new HashMap<String, String>();
		map.put("age", "33"); // String 넣기로 했으니까 33 문자로 함
		map.put("hobby", "음주가무");
		
		System.out.println("test 실행");
		
		return map;
	}

}

// 리턴타입
// 1. ModelAndView : 모델객체와 뷰페이지 지정을 같이
// 2. String : 뷰 파일을 지정 _ 모델지정 안하고 화면만 가져오는...
// 3. void : request 이름과 동일한 뷰 파일을 찾음
// 4. Model : 모델객체 전송
// 5. Map : HashMap<key, value> 객체를 전송
// 6. View : 뷰 객체를 전송 -> 한번 찾아서 해볼것
