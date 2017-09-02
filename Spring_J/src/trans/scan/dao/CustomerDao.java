package trans.scan.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import trans.vo.CustomerVO;

@Repository
public class CustomerDao {
	
		@Autowired
		private SqlSessionTemplate ss;
		//Spring이 sqlSession도 객체 생성 담당

	public void addCustomer(CustomerVO vo){
			ss.insert("customer.addCustomer",vo);
			//마이바티즈 호출
		
	}
	
	
}
