package trans.scan.service;

import trans.vo.CustomerVO;
import trans.vo.MemberVO;

public interface ServiceTx {

	public void addAll(CustomerVO cvo, MemberVO mvo) throws Exception;
}
