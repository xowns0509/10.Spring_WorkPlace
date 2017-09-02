package trans.scan.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import trans.vo.MemberVO;

public class MemberDao {

	//커넥션이 필요
	// 스프링이 주입해야 하니
	@Autowired
	private SqlSessionTemplate ss;
	
	public void addMember(MemberVO vo){
		
		ss.insert("member.addMember", vo);//"" 안에 들어가는 건 memberxml가서 찾아와
		////네임스페이스 + 마이바티스id 이므로
		
	}
	
}
