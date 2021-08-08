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

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/history" })
public class HistoryServlet extends HttpServlet{

	private TransactionRepository transactionRepository = new TransactionRepositoryImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Transaction> txns = transactionRepository.getTransaction();
		req.setAttribute("txns", txns);
		req.getRequestDispatcher("history.jsp").forward(req, resp);
	}
	
}
