package com.yq.servlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.yq.dao.CustomerDao;
import com.yq.dao.FilmDao;
import com.yq.dao.LanguageDao;
import com.yq.dao.impl.CustomerDaoImpl;
import com.yq.dao.impl.FilmDaoImpl;
import com.yq.dao.impl.LanguageDaoImpl;
import com.yq.entity.Customer;
import com.yq.entity.Film;
import com.yq.jdbc.ConnectionFactory;

public class CheckCustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao = new CustomerDaoImpl();
	private FilmDao filmDao = new FilmDaoImpl();
	private LanguageDao languageDao = new LanguageDaoImpl();

	public boolean check(Customer cust) {

		Connection conn = null;

		try {
			conn = ConnectionFactory.getInstance().makeConnection();

			conn.setAutoCommit(false);

			ResultSet resultSet = customerDao.get(conn, cust);

			while (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}

	public List<Film> readResult() {

		List<Film> list = new ArrayList<Film>();

		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();

			conn.setAutoCommit(false);

			rs = filmDao.get(conn);

			while (rs.next()) {
				int film_id = rs.getInt("film_id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String name = rs.getString("name");
				Film film = new Film(film_id, title, description, name);
				list.add(film);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	public List<String> readLanguageId() {

		List<String> list = new ArrayList<String>();

		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();

			conn.setAutoCommit(false);

			rs = languageDao.get(conn);

			while (rs.next()) {
				String language = rs.getString("name");
				list.add(language);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
}
