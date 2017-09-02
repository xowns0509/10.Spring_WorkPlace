package trans.scan.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import trans.vo.ReceiverVO;
import trans.vo.SenderVO;


@Repository
public class TransferDAOImpl implements TransferDAO {
	@Autowired
	private SqlSessionTemplate ss;
	
	
	@Transactional(rollbackFor=TransException.class)
	@Override
	public void transfer(SenderVO send, ReceiverVO recv) throws Exception{

		int resultSend = ss.update("trans.withdraw", send);
		if( resultSend == 0) throw new TransException();
		System.out.println("인출");
		int resultRecv = ss.update("trans.deposit", recv);
		if( resultRecv == 0) throw new TransException();
		System.out.println("입금");
	}

}
