package com.yq.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PermissonFilter implements Filter {

	public PermissonFilter() {

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		RequestDispatcher rd = null;
		String flag = null;
		HttpServletRequest hst = (HttpServletRequest) request;
		HttpSession hs = hst.getSession();
		String sr = hst.getServletPath();
		flag = (String) hs.getAttribute("session_flag");
		//System.out.println(sr);
		//System.out.println(flag);
		if (sr.equals("/jsp/index.jsp") || sr.equals("/CheckServlet") || sr.equals("/jsp/login.jsp")) {
			chain.doFilter(request, response);
		} else {
			if (flag != null && flag.equals("success")) {
				chain.doFilter(request, response);
			} else {
				rd = request.getRequestDispatcher("/jsp/login.jsp");
				rd.forward(request, response);
			}
		}
	}

	public void destroy() {

	}

}
