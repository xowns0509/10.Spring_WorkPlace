package myproj.member.dao;

import java.util.ArrayList;

import myproj.member.dto.MemberVO;

public interface MemberDAO {
	/**
	 * id 체크
	 */	
	MemberVO  idCheck( MemberVO vo );
	
	/**
	 * db에 멤버 입력
	 */
	int memberInsert(MemberVO vo);
	
	/**
	 * 로그인 모듈?
	 */
	MemberVO memberLogin(MemberVO vo);
	
	/**
	 * 리스트 가져오기
	 */
	ArrayList<MemberVO> memberList();
}
