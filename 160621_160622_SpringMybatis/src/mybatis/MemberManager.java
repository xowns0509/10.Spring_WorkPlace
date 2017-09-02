package mybatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import myproj.member.dto.MemberVO;

public class MemberManager {

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
	
	
	/**
	  * 아이디 중복 체크하는 sql + 로그인 기능 sql
	  */
	  public static MemberVO idCheck_Login( MemberVO vo) throws Exception
	  {
		  // user라는 네임스페이스를 사용하기에 아이디값을 적을 때 같이 기술
		  SqlSession session = sqlMapper.openSession();
		  MemberVO dbVo = (MemberVO) session.selectOne("user.idCheck", vo);
		   return dbVo; // arg0: 아이디  arg1:전단될 파라미터 arg2:인덱스값
	  }
	  
	  
	  /**
	   * 회원가입 sql
	   */
	   public static int userInsert(MemberVO vo ) throws SQLException
	   {
		   SqlSession session = sqlMapper.openSession();
		   int result = session.update("user.userInsert", vo);
		   session.commit();
		   	return result;	// insert()은 리턴타입이 Object이기도 하고 update()을 사용해도 무방
	   }
}
