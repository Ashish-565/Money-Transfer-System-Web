package com.revature.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.entity.Transaction;
import com.revature.repository.TransactionRepository;
import com.revature.repository.TransactionRepositoryImpl;
import com.revature.service.TransferService;
import com.revature.service.TransferServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/new-transaction", "/all-txns" })
public class TransactionServlet extends HttpServlet{

	private TransactionRepository transactionRepository = new TransactionRepositoryImpl();
	TransferService transferService = new TransferServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Transaction> txns = transactionRepository.getTransaction(HistoryServlet.account);
		req.setAttribute("txns", txns);
		req.getRequestDispatcher("all.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fromAccount = req.getParameter("fromAccount");
		String toAccount = req.getParameter("toAccount");
		double amount = Double.parseDouble(req.getParameter("amount"));
		
		transferService.txr(fromAccount, toAccount, amount);

		resp.sendRedirect("transaction.html");
	}
	
}
