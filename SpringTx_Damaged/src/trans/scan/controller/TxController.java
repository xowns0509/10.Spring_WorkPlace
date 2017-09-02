package trans.scan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import trans.scan.service.ServiceTx;
import trans.vo.CustomerVO;
import trans.vo.MemberVO;

//컨트롤러역할
@Controller
public class TxController {
	
	@Autowired
	private ServiceTx service;
	
	@RequestMapping("/form.do")
	public String txForm(){
		return "form";
		
	}
	
	@RequestMapping(value="/transfer.do", method=RequestMethod.POST)
	public ModelAndView addAll(CustomerVO cvo, MemberVO mvo) throws Exception{
		
		service.addAll(cvo, mvo);
		
		ModelAndView mv = new ModelAndView("result");//스트링 인자 하나면 요게 뷰단 페이지.
		
		mv.addObject("msg", "성공적인 입력 확인!!");
		
		return mv; 
	}


}
