package trans.scan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trans.scan.dao.CustomerDao;
import trans.scan.dao.MemberDao;
import trans.vo.CustomerVO;
import trans.vo.MemberVO;

@Service
public class ServiceTxImpl implements ServiceTx {

	@Autowired
	private MemberDao mdao;
	
	@Autowired
	private CustomerDao cdao;
	
	@Transactional
	@Override
	public void addAll(CustomerVO cvo, MemberVO mvo) throws Exception  {
		mdao.addMember(mvo);
		System.out.println("회원 입력 성공~~~~~~ㅋ");
		cdao.addCustomer(cvo);
		System.out.println("고객 입력 성공~~~~~~~");
	}

}
