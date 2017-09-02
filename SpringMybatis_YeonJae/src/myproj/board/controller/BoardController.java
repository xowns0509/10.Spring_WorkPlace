package myproj.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import myproj.board.dao.BoardDAO;
import myproj.board.dto.BoardVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	@Resource(name="board")
	private BoardDAO board;
	
	//각 매핑에 따른 매핑을 맞추고 모델호출 후 뷰단 지정 하기
	//게시글 목록 가져오기
	@RequestMapping(value="/list.do")
	public ModelAndView toListBoard(){	
		System.out.println("리스트 리스트");
		List<BoardVO> list = board.list();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");
		
		mv.addObject("listModel", list);
		return mv;
	}
	
	@RequestMapping(value="/write.do")
	public void toWriteBoard(){}
	
	@RequestMapping(value="/write_ok.do")
	public ModelAndView isWriteOk(BoardVO vo){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/write_ok");
		mv.addObject("message", "게시글 입력!");
		
		System.out.println(vo.getB_name());
		int result = board.boardInsert(vo);
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping(value="view.do")
	public ModelAndView view(BoardVO vo){
		System.out.println(vo.getB_id());
		
		ModelAndView mv = new ModelAndView();
		
		BoardVO ret = board.boardView(vo);
		mv.setViewName("board/view");
		mv.addObject("model", ret);
		
		return mv;
	}
}

