package com.revature.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	private String account;
	private Date date;
	private double amount;
	private TxrType creditOrDebit;
	
	public Transaction(String account, Date date, double amount, TxrType creditOrDebit) {
		super();
		this.account = account;
		this.date = date;
		this.amount = amount;
		this.creditOrDebit = creditOrDebit;
	}
	
	public Transaction() {

	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TxrType getCreditOrDebit() {
		return creditOrDebit;
	}

	public void setCreditOrDebit(TxrType creditOrDebit) {
		this.creditOrDebit = creditOrDebit;
	}

	@Override
	public String toString() {
		return "TransactionId = " + transactionId + ", Account Number = " + account+ ", date = " + date + ", amount = " + amount
				+ ", creditOrDebit = " + creditOrDebit;
	}
	
}
