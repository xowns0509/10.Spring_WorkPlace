package proj.security.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import proj.security.dao.BbsDao;
import proj.vo.BbsCommVO;
import proj.vo.BbsVO;
import proj.vo.PageVO;
import proj.vo.SearchVO;



@Controller
public class BbsController {
	 @Autowired
	 private BbsDao dao;
	 
	@RequestMapping(value="/bbsForm")
	public String bbsForm(){
		return "/bbs/bbsForm";
	}
	
	@RequestMapping(value="/bbsIn",method=RequestMethod.POST)
	 public ModelAndView insert(BbsVO vo){
	  dao.insertBbs(vo);
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("redirect:/bbsList");
	  return mav;
	 }
	 @RequestMapping(value="/bbsList")
	 public ModelAndView list(Integer page, SearchVO vo,Principal principal){
		 //*** Principal : security에서 넣어주는 파라메타
	  
	  // pageVO의 획득
	  int totalRows = dao.getTotalCount();
	  PageVO pageInfo = makePageVO(page, totalRows);
	  
	  // 보여줄 페이지 설정
	  vo.setBegin(String.valueOf(pageInfo.getStartRow()));
	  vo.setEnd(String.valueOf(pageInfo.getEndRow()));
	  
	  // 보여줄 리스트 획득
	  List<BbsVO> list = dao.getList(vo);
	  
	  
	 // System.out.println(list.size());
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("bbs/bbsList");
	  mav.addObject("list", list);
	  mav.addObject("pageInfo", pageInfo); // pageInfo 전달
	  if(principal != null)
	  mav.addObject("principal", principal.getName());
	  return mav;
	 }
	 


	 
	 public PageVO makePageVO(Integer page, int totalRows) {
	  
	  PageVO pageInfo = new PageVO();
	  int rowsPerPage = 15; // 한페이지당 보여줄 목록수 - properties
	  int pagesPerBlock = 5; // 한 블록당 보여줄 페이지 수 - properties
	  if (page == null) page = 0;
	  if(page  == 0) page = 1; //페이지 초기화
	  int currentPage = page; // 현재 페이지 값
	  int currentBlock = 0; // 현재 블록 초기화
	  if (currentPage % pagesPerBlock == 0) { // 현재 블록 초기값
	   currentBlock = currentPage / pagesPerBlock;
	  } else { // 다음 블록이냐
	   currentBlock = currentPage / pagesPerBlock + 1;
	  }
	  int startRow = (currentPage - 1) * rowsPerPage + 1; // 시작목록값연산
	  int endRow = currentPage * rowsPerPage;// 마지막 목록값 연산

	  
	  // 전체 데이터 값
	  
	  //System.out.println("totalRows:" + totalRows);
	  // 전체 페이지 구하는 공식
	  int totalPages = 0;
	  if (totalRows % rowsPerPage == 0) {
	   totalPages = totalRows / rowsPerPage;
	  } else {
	   totalPages = totalRows / rowsPerPage + 1;
	  }
	  // 전체 블록값을 구하는 공식
	  int totalBlocks = 0;
	  if (totalPages % pagesPerBlock == 0) {
	   totalBlocks = totalPages / pagesPerBlock;
	  } else {
	   totalBlocks = totalPages / pagesPerBlock + 1;
	  }
	  // 모든 연산된정보를 PageVO에 저장한다.
	  pageInfo.setCurrentPage(currentPage);
	  pageInfo.setCurrentBlock(currentBlock);
	  pageInfo.setRowsPerPage(rowsPerPage);
	  pageInfo.setPagesPerBlock(pagesPerBlock);
	  pageInfo.setStartRow(startRow);
	  pageInfo.setEndRow(endRow);
	  pageInfo.setTotalRows(totalRows);
	  pageInfo.setTotalPages(totalPages);
	  pageInfo.setTotalBlocks(totalBlocks);
	  
	  return pageInfo;
	 }
	 
	 @RequestMapping(value="/bbsDetail",method=RequestMethod.GET)
	 public ModelAndView detail(int num,Principal principal){
		 
	  BbsVO vo  = dao.getDetail(num);
	  //댓글을 리스트하기 위한 Dao를 호출
	  List<BbsCommVO> cList = dao.getCommList(num);
	  
	  dao.BbsHitUp(num);
	  
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("bbs/bbsDetail");
	  mav.addObject("vo", vo);
	  mav.addObject("cList", cList);
	 // mav.addObject("principal", principal.getName());
	  return mav;
	 }
	 @RequestMapping(value="/bbsComm",method=RequestMethod.POST)
	 public ModelAndView bbsCommin(BbsCommVO v){
	 // System.out.println("writer : "+v.getWriter());
	  dao.insertComm(v);
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("redirect:/bbsDetail?num="+v.getKcode());
	  // num값을 보내지 않으면 뷰가 안만들어짐..
	  return mav;
	  
	 }
	
}
