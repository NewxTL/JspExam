package com.yq.dao.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;

import com.yq.dao.FilmDao;
import com.yq.entity.Film;

public class FilmDaoImpl implements FilmDao {
	
	

	public void save(Connection conn, Film film) throws SQLException {

	}

	public void update(Connection conn, Long id, Film film) throws SQLException {

	}

	public void insert(Connection conn, Film film) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("insert into  film (film_id,title,description,language_id) values(?,?,?,2)");
		ps.setInt(1, film.getFilm_id());
		ps.setString(2, film.getTitle());
		ps.setString(3, film.getDescription());
		
		ps.executeUpdate();
	}

	public void delete(Connection conn, String film_id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete from film where film_id = ?");
		ps.setString(1, film_id);
		ps.executeUpdate();
		
	}

	public ResultSet get(Connection conn, Film film) throws SQLException {
		return null;
	}

	public ResultSet get(Connection conn) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("select f.*,l.name from film f,language l where f.language_id =l.language_id ");
		return ps.executeQuery();
	}
}
