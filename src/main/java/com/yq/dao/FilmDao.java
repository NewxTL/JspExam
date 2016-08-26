package com.yq.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yq.entity.Film;

public interface FilmDao {

	public void save(Connection conn, Film cust) throws SQLException;

	public void update(Connection conn, Long id, Film cust) throws SQLException;

	public void insert(Connection conn, Film cust) throws SQLException;

	public void delete(Connection conn, String film_id) throws SQLException;

	public ResultSet get(Connection conn, Film cust) throws SQLException;

	public ResultSet get(Connection conn) throws SQLException;
}
