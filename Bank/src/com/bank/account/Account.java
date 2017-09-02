package com.bank.account;

public class Account {
	private int nol;
	private String name;
	private long balance;
	
	public Account() {
		super();
	}
	public Account(int nol, String name, long balance) {
		super();
		this.nol = nol;
		this.name = name;
		this.balance = balance;
	}
	
	public int getNol() {
		return nol;
	}
	public void setNol(int nol) {
		this.nol = nol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	
}
