package trans.scan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trans.scan.dao.CustomerDao;
import trans.scan.dao.MemberDao;
import trans.vo.CustomerVO;
import trans.vo.MemberVO;

@Service//이거 달면 '이 클래스는 서비스클래스'야 라고 표시해주는 거.
public class ServiceTxImpl implements ServiceTx {
	
	@Autowired
	private MemberDao mdao;

	@Autowired
	private CustomerDao cdao;

	@Override
	public void addAll(CustomerVO cvo, MemberVO mvo) throws Exception {
		// 
		
		mdao.addMember(mvo);
		System.out.println("회원입력 성공");
		
		cdao.addCustomer(cvo);
		System.out.println("고객입력 성공");
	}

}
