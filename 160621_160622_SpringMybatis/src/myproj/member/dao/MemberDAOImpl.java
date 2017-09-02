package myproj.member.dao;

import java.sql.SQLException;

import mybatis.MemberManager;
import myproj.member.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public MemberVO idCheck(MemberVO vo) {
		MemberVO memberVo = null;
		try{
			memberVo = MemberManager.idCheck_Login(vo);
		}catch( Exception ex )
		{
			System.out.println("MemberDAOImpl / idCheck 실패 : " + ex.getMessage());
		}
		return memberVo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		int result = 0;
		try {
			result = MemberManager.userInsert(vo);
		} catch (SQLException e) {
			System.out.println("MemberDAOImpl / memberInsert 실패 : " + e.getMessage());
		}
		return result;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		MemberVO memberVo = null;
		try{
			memberVo = MemberManager.idCheck_Login(vo);
		}catch( Exception ex )
		{
			System.out.println("MemberDAOImpl / idCheck 실패 : " + ex.getMessage());
		}
		return memberVo;
	}

}
