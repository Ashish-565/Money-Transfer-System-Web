package com.revature.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.revature.entity.Transaction;
import com.revature.jpa.LocalEntityManageFactory;

public class TransactionRepositoryImpl implements TransactionRepository{

	@Override
	public void save(Transaction transaction) {
		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		em.persist(transaction);
		
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransaction() {
		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		List<Transaction> txns = em.createQuery("from Transaction").getResultList();
		
		em.getTransaction().commit();
		em.close();
		return txns;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransaction(int limit) {
		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		List<Transaction> txns = em.createQuery("from Transaction order by transactionid desc limit "+limit).getResultList();
		
		em.getTransaction().commit();
		em.close();
		return txns;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransaction(Date fromDate, Date toDate) {
		EntityManager em = LocalEntityManageFactory.emf().createEntityManager();
		em.getTransaction().begin();
		
		List<Transaction> txns = em.createQuery("from Transaction where date between "+fromDate+" and "+toDate).getResultList();
		
		em.getTransaction().commit();
		em.close();
		return txns;
	}

}
