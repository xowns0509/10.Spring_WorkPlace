package mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import myproj.board.dto.BoardVO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardManager {
	
	private static SqlSessionFactory sqlMapper;
	
	static{
		String resource = "mybatis/SqlMapConfig.xml";
		try{
		
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch( IOException ex)
		{
			System.out.println("MemberManager fail : " + ex.getMessage());
		}
	}
	
	// 게시판 목록 가져오기
	public static List<BoardVO> getList(){
		List<BoardVO> list = null;
		SqlSession session = sqlMapper.openSession();
		list = session.selectList("board.getList");
		
		return list;
	}
	
	// 게시물 입력하기
	public static int boardInsert(BoardVO vo){
		SqlSession session = sqlMapper.openSession();
		
		int result = session.insert("board.boardInsert", vo);
		session.commit();
		return result;
	}
	
	/**
	 * 게시물을 보기전에 조회수를 올려주고 update 실행시 오류가 있으면 BoardVO 객체를 
	 * null 로 처리해서 오류 잡기
	 * @param vo
	 * @return
	 */
	public static BoardVO boardView( BoardVO vo){
		SqlSession session = sqlMapper.openSession();
		BoardVO ret = null;
		int result = 0;
		
		//조회수 올려주기 
		result = session.update("board.viewCount", vo);
		session.commit();
		
		//게시물 보여주기
		if(result > 0) ret = session.selectOne("board.boardView", vo );	
		
		return ret;
	}	
}
