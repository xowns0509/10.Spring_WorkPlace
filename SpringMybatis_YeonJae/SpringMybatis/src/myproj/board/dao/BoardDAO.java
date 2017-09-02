package myproj.board.dao;

import java.util.List;

import myproj.board.dto.BoardVO;

public interface BoardDAO {
		/**
		 * 게시물 목록 가져오기
		 */
		List<BoardVO> list();
	
		/**
		 * 게시물 등록하기
		 */
		int boardInsert( BoardVO vo);
	
		/**
		 * 조건에 의해 게시물 목록 가져오기
		 */
		List<BoardVO> searchList(String keyField, String keyWord );
		
		/**
		 * 해당 게시물 보여주기
		 */
		BoardVO boardView(BoardVO vo);
}
