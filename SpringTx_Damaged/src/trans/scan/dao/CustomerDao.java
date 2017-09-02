package trans.scan.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import trans.vo.CustomerVO;

@Repository//
public class CustomerDao {
	
	@Autowired
	private SqlSessionTemplate ss;
	// new를 안 사용하기로 했으니 이 객체마저 스프링이 담당
	// 그럼 @Autowired사용해야지
	
	public void addCustomer(CustomerVO vo){
		//sql 세션
		ss.insert("customer.addCustomer", vo);//네임스페이스 + 마이바티스id
		
	}

}
