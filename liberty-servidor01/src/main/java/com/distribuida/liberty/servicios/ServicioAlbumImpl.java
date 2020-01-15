package com.distribuida.liberty.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.distribuida.liberty.dto.Album;

@ApplicationScoped
public class ServicioAlbumImpl implements ServicioAlbum{

	@Inject
	private DataSource dataSource;

	@Override
	public List<Album> listar() {

		List<Album> albums = new ArrayList<>();
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			sta = con.prepareStatement("SELECT * FROM album");
			rs = sta.executeQuery();
			while (rs.next()) {
				Album a = new Album();
				a.setId(rs.getInt(1));
				a.setSingerId(rs.getInt(2));
				a.setTitle(rs.getString(3));
				a.setReleaseDate(rs.getDate(4));
				a.setVersion(rs.getInt(5));
				albums.add(a);
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
		}
		return albums;
	}


	@Override
	public Album buscarPorId(Integer id) {
		Album album = new Album();
		String query = "SELECT * FROM album WHERE id= ?";
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				album.setId(rs.getInt(1));
				album.setSingerId(rs.getInt(2));
				album.setReleaseDate(rs.getDate(3));
				album.setTitle(rs.getString(4));
				album.setVersion(rs.getInt(5));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return album;
	}

}
