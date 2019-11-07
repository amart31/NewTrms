package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.OptionalFileBean;
import com.revature.dao.OptionalFileDao;
import com.revature.util.ConnFactory;

public class OptionalFileDaoImpl implements OptionalFileDao {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public OptionalFileBean getOneFile(int infoID) {
		Connection conn = cf.getConnection();
		String str = "select * from trms_optional_info where info_id = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(str);
			ps.setInt(1, infoID);
			ResultSet rs = ps.executeQuery();
			OptionalFileBean of = null;
			while (rs.next()) {
				of = new OptionalFileBean(rs.getInt(1), rs.getInt(2), rs.getString(3));
				return of;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<OptionalFileBean> getFiles(int formID) {
		ArrayList<OptionalFileBean> files = new ArrayList<OptionalFileBean>();
		Connection conn = cf.getConnection();
		String str = "select * from trms_optional_info where form_id = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(str);
			ps.setInt(1, formID);
			ResultSet rs = ps.executeQuery();
			OptionalFileBean of = null;
			while (rs.next()) {
				of = new OptionalFileBean(rs.getInt(1), rs.getInt(2), rs.getString(3));
				files.add(of);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return files;
	}
	
	
	@Override
	public boolean uploadNewFile(OptionalFileBean of) {
		Connection conn = cf.getConnection();
		String str = "insert into trms_optional_info values (nextval('optional_info_seq'),?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(str);
			ps.setInt(1, of.getForm_id());
			ps.setString(2, of.getInfo_name());
			ps.execute();
			ps = conn.prepareStatement("commit");
			ps.execute();
			ps = conn.prepareStatement("select currval('optional_info_seq')");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				of.setInfo_id(rs.getInt(1));
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public int uploadNewFile(int formID, String infoName) {
		Connection conn = cf.getConnection();
		String str = "insert into trms_optional_info values (nextval('optional_info_seq'),?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(str);
			ps.setInt(1, formID);
			ps.setString(2, infoName);
			ps.execute();
			ps = conn.prepareStatement("commit");
			ps.execute();
			ps = conn.prepareStatement("select currval('optional_info_seq')");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	@Override
	public boolean removeInfo(int formID) {
		Connection conn = cf.getConnection();
		String str1 = "delete from trms_optional_info where form_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(str1);
			ps.setInt(1, formID);
			ps.execute();
			ps=conn.prepareStatement("commit");
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public boolean removeInfo(OptionalFileBean file) {
		Connection conn = cf.getConnection();
		String str1 = "delete from trms_optional_info where form_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(str1);
			ps.setInt(1, file.getForm_id());
			ps.execute();
			ps=conn.prepareStatement("commit");
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
