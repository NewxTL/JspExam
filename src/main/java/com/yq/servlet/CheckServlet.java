package com.yq.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yq.entity.Customer;

public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CheckCustomerServlet cku = new CheckCustomerServlet();

	public CheckServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String first_name = request.getParameter("first_name");

		RequestDispatcher rd = null;
		String forward = null;

		Customer cust = new Customer();
		cust.setFirst_name(first_name);

		boolean bool = cku.check(cust);

		HttpSession hs = request.getSession();

		// boolean bool = true;
		// System.out.println(bool);
		// System.out.println(cust.getFirst_name());
		if (bool) {
			hs.setAttribute("session_flag", "success");
			forward = "/jsp/index.jsp";
		} else {
			hs.setAttribute("session_flag", "error");
			request.setAttribute("msg", "用户名或者密码输入错误，请重新输入");
			forward = "/jsp/error.jsp";
		}
		
		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);

	}

}
