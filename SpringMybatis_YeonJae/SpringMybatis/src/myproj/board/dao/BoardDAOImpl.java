package myproj.board.dao;

import java.util.List;

import mybatis.BoardManager;
import myproj.board.dto.BoardVO;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public List<BoardVO> list() {
	
		return BoardManager.getList();
	}

	@Override
	public int boardInsert(BoardVO vo) {
		
		return BoardManager.boardInsert(vo);
	}

	@Override
	public List<BoardVO> searchList(String keyField, String keyWord) {
	
		return null;
	}

	@Override
	public BoardVO boardView(BoardVO vo) {
		
		return BoardManager.boardView(vo);
	}
	

}
