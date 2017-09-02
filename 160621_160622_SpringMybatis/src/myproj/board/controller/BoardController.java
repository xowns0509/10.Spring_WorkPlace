package myproj.board.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import myproj.board.dao.BoardDAO;


@Controller
public class BoardController {
	// 각 요청에 따른 매핑 맞추고
	// 모델 호출 후 뷰단 지정까지 알아서 잘.

	@Resource(name = "boardDAOxml")
	private BoardDAO boardDAO;
	
	@RequestMapping(value = "/board/list.do")
	public void boardList() {

	}
	
	@RequestMapping(value = "/board/write.do")
	public void write() {

	}
	
	@RequestMapping(value = "/board/write_ok.do")
	public void writeOk(BoardDAO bDAO) {
		
		boardDAO.boardInsert(bDAO);

	}


//	@RequestMapping(value = "user/{url}.do")
//	public void test() {
//
//	}

}
