package com.bank.account;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountManagementTest {
	
	private AccountManagement accMgnt;

	@Before
	public void init(){
		accMgnt = new AccountManagement();
		
	}

	@Test
	public void testDeposit(){
		Account kim = new Account(1, "kim", 1000);
		long amount = accMgnt.deposit(kim, 200);
		assertEquals(1200, kim.getBalance());		
//		1000 + 200 하여 1200 이 나올 수 있게끔 개발하면 된다이거지
		//이렇게 테스트 코딩을 먼저 만드는 것이 TDD
	}
	
	@Test
	public void testWithdrawal(){
		Account lee = new Account(2, "lee", 1000);
		long amount = accMgnt.withdrawal(lee, 3000);
		assertEquals(4000, lee.getBalance());
	}
}
