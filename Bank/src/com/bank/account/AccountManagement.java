package com.bank.account;

import com.bank.account.exception.NotMoneyException;

public class AccountManagement {
	
	// 입금관련 실제 코딩이 구현 않 된 메소드
	public int deposit(Account account, long amount){
		long balance = account.getBalance();
		account.setBalance(balance + amount);
		return 0;// 의미 없는 반환
		
	}
	
	public int withdrawal(Account account, long amount){
		long balance = account.getBalance();
		if(balance < amount){
			throw new NotMoneyException("잔액이 부족합니다");
			
		}
		account.setBalance(balance - amount);
		return 0;
		
	}

}
