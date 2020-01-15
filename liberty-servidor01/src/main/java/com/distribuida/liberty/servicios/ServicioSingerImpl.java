package com.distribuida.liberty.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.distribuida.liberty.dto.Singer;

@ApplicationScoped
public class ServicioSingerImpl implements ServicioSinger {

	@Inject
	private DataSource dataSource;	

	@Override
	public List<Singer> listar() {

		List<Singer> singers = new ArrayList<>();
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			sta = con.prepareStatement("SELECT * FROM singer");
			rs = sta.executeQuery();
			while (rs.next()) {
				Singer singer = new Singer();
				singer.setId(rs.getInt("id"));
				singer.setFirstName(rs.getString("first_name"));
				singer.setLastName(rs.getString("last_name"));
				singer.setBirthDate(rs.getDate("birth_date"));
				singer.setVersion(rs.getInt("version"));
				singers.add(singer);
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
		}
		return singers;
	}


	@Override
	public Singer buscarPorId(Integer id) {
		Singer singer = new Singer();
		String query = "SELECT * FROM singer WHERE id= ?";
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				singer.setId(rs.getInt(1));
				singer.setBirthDate(rs.getDate(2));
				singer.setFirstName(rs.getString(3));
				singer.setLastName(rs.getString(4));
				singer.setVersion(rs.getInt(5));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return singer;
	}

}
