package mybatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

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
	  * ���̵� �ߺ� üũ�ϴ� sql + �α��� ��� sql
	  */
	  public static MemberVO idCheck_Login( MemberVO vo) throws Exception
	  {
		  // user��� ���ӽ����̽��� ����ϱ⿡ ���̵��� ���� �� ���� ���
		  SqlSession session = sqlMapper.openSession();
		  MemberVO dbVo = (MemberVO) session.selectOne("user.idCheck", vo);
		   return dbVo; // arg0: ���̵�  arg1:���ܵ� �Ķ���� arg2:�ε�����
	  }
	  
	  
	  /**
	   * ȸ������ sql
	   */
	   public static int userInsert(MemberVO vo ) throws SQLException
	   {
		   SqlSession session = sqlMapper.openSession();
		   int result = session.update("user.userInsert", vo);
		   session.commit();
		   	return result;	// insert()�� ����Ÿ���� Object�̱⵵ �ϰ� update()�� ����ص� ����
	   }
	   
	   public static List<MemberVO> memberList() throws Exception{
		   SqlSession session = sqlMapper.openSession();
		   List<MemberVO> list = session.selectList("user.memberList");
		   return list; 		   
	   }
}
