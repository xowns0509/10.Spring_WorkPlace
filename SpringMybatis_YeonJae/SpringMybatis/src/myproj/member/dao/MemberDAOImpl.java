package myproj.member.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			System.out.println("MemberDAOImpl / idCheck ���� : " + ex.getMessage());
		}
		return memberVo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		int result = 0;
		try {
			result = MemberManager.userInsert(vo);			
		} catch (SQLException e) {
			System.out.println("MemberDAOImpl / memberInsert ���� : " + e.getMessage());
		}
		System.out.println("입력성공");
		return result;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		MemberVO memberVo = null;
		try{
			memberVo = MemberManager.idCheck_Login(vo);
		}catch( Exception ex )
		{
			System.out.println("MemberDAOImpl / idCheck ���� : " + ex.getMessage());
		}
		return memberVo;
	}
	
	public ArrayList<MemberVO> memberList(){
		List<MemberVO> list = new ArrayList<MemberVO>();
			
		try{
			list = MemberManager.memberList();
		}catch(Exception ex){
			System.out.println("MemberDAOImpl / memberList : " + ex.getMessage());
		}
		
		return (ArrayList)list;
	}
}
