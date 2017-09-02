package trans.scan.dao;

import trans.vo.ReceiverVO;
import trans.vo.SenderVO;

public interface TransferDAO {

	public void transfer(SenderVO sender, ReceiverVO receiver)  throws Exception;
}
