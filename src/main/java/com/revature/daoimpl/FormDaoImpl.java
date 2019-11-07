package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.FormBean;
import com.revature.dao.FormDao;
import com.revature.util.ConnFactory;

public class FormDaoImpl implements FormDao {
	public static ConnFactory cf = ConnFactory.getInstance();
	OptionalFileDaoImpl ofdi= new OptionalFileDaoImpl();

	
	@Override
	public FormBean getForm(int formID) {
		Connection conn = cf.getConnection();
		String str = "select * from trms_forms where form_id = ? ";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(str);
			ps.setInt(1, formID);
			ResultSet rs = ps.executeQuery();
			FormBean form = null;
			while (rs.next()) {
				form = new FormBean(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getTime(5),
						rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getDouble(14), rs.getBoolean(15),
						rs.getBoolean(16), rs.getBoolean(17), rs.getBoolean(18), rs.getBoolean(19),rs.getBoolean(20));
				form.setOptionalFiles(ofdi.getFiles(rs.getInt(1)));
				return form;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<FormBean> getAllForms() {
		ArrayList<FormBean> forms = new ArrayList<FormBean>();
		Connection conn = cf.getConnection();
		String str = "select * from trms_forms";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			FormBean form = null;
			while (rs.next()) {
				form = new FormBean(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getTime(5),
						rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getDouble(14), rs.getBoolean(15),
						rs.getBoolean(16), rs.getBoolean(17), rs.getBoolean(18), rs.getBoolean(19),rs.getBoolean(20));
				form.setOptionalFiles(ofdi.getFiles(rs.getInt(1)));
				forms.add(form);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forms;
	}

	@Override
	public ArrayList<FormBean> getFormsForSupervisor(int supID) {
		ArrayList<FormBean> forms = new ArrayList<FormBean>();
		Connection conn = cf.getConnection();
		String str = "select * from trms_forms where direct_supervisor_id = ? and direct_supervisor_approved = false";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(str);
			ps.setInt(1, supID);
			ResultSet rs = ps.executeQuery();
			FormBean form = null;
			while (rs.next()) {
				form = new FormBean(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getTime(5),
						rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getDouble(14), rs.getBoolean(15),
						rs.getBoolean(16), rs.getBoolean(17), rs.getBoolean(18), rs.getBoolean(19),rs.getBoolean(20));
				form.setOptionalFiles(ofdi.getFiles(rs.getInt(1)));
				forms.add(form);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forms;
	}

	@Override
	public ArrayList<FormBean> getFormsForDepHead(String department) {
		ArrayList<FormBean> forms = new ArrayList<FormBean>();
		Connection conn = cf.getConnection();
		String str = "select * from trms_forms where department = ? and direct_supervisor_approved = true and department_head_approved=false";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(str);
			ps.setString(1, department);
			ResultSet rs = ps.executeQuery();
			FormBean form = null;
			while (rs.next()) {
				form = new FormBean(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getTime(5),
						rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getDouble(14), rs.getBoolean(15),
						rs.getBoolean(16), rs.getBoolean(17), rs.getBoolean(18), rs.getBoolean(19),rs.getBoolean(20));
				form.setOptionalFiles(ofdi.getFiles(rs.getInt(1)));
				forms.add(form);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forms;
	}

	@Override //TODO add denied = false
	public ArrayList<FormBean> getFormsForCoordinator() {
		ArrayList<FormBean> forms = new ArrayList<FormBean>();
		Connection conn = cf.getConnection();
		String str = "select * from trms_forms where direct_supervisor_approved = true and department_head_approved=true and benefits_coordinator_approved = false";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			FormBean form = null;
			while (rs.next()) {
				form = new FormBean(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getTime(5),
						rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getInt(13), rs.getDouble(14), rs.getBoolean(15),
						rs.getBoolean(16), rs.getBoolean(17), rs.getBoolean(18), rs.getBoolean(19),rs.getBoolean(20));
				form.setOptionalFiles(ofdi.getFiles(rs.getInt(1)));
				forms.add(form);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forms;
	}

	@Override
	public boolean uploadNewForm(FormBean form) {
		Connection conn = cf.getConnection();
		
		String str = "insert into trms_forms values (nextval('form_seq'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
				
		try {
			PreparedStatement ps;
			ps = conn.prepareStatement(str);
			ps.setInt(1, form.getEmployee_id());
			ps.setInt(2, form.getDirect_supervisor_id());
			ps.setDate(3, form.getSubmit_date());
			ps.setTime(4, form.getSubmit_time());
			ps.setString(5, form.getEvent_location());
			ps.setString(6, form.getDescription());
			ps.setDouble(7, form.getEvent_cost());
			ps.setInt(8, form.getGrading_format());
			ps.setString(9, form.getType_of_event());
			ps.setString(10, form.getJustification());
			ps.setString(11, form.getDepartment());
			ps.setInt(12, form.getGrade_type());
			ps.setDouble(13, form.getGrade());
			ps.setBoolean(14, form.isUrgent());
			ps.setBoolean(15, form.isDirect_supervisor_approved());
			ps.setBoolean(16, form.isDepartment_head_approved());
			ps.setBoolean(17, form.isBenefits_coordinator_approved());
			ps.setBoolean(18, form.isFinal_confirmation());
			ps.setBoolean(19, form.isDenied());
			ps.execute();
			
			ps=conn.prepareStatement("commit");
			ps.execute();
			ps = conn.prepareStatement("select currval('form_seq')");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				form.setForm_id(rs.getInt(1));
			}
			System.out.println("Successfully uploaded form");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return false;
	}

	@Override
	public boolean updateForm(FormBean form) {
		Connection conn = cf.getConnection();
		String str = "update trms_forms "
				+ "set employee_id=?, direct_supervisor_id=?, submit_date=?, submit_time=?, event_location=?," 
				+ " description=?, event_cost=?, grading_format=?, type_of_event=?, justification=?," 
				+ " department=?, grade_type=?, grade=?, urgent=?, direct_supervisor_approved=?," 
				+ " department_head_approved=?, benefits_coordinator_approved=?, final_confirmation=?, denied=? "
				+ "where form_id=?";
		try {
			PreparedStatement ps;
			ps = conn.prepareStatement(str);
			ps.setInt(1, form.getEmployee_id());
			ps.setInt(2, form.getDirect_supervisor_id());
			ps.setDate(3, form.getSubmit_date());
			ps.setTime(4, form.getSubmit_time());
			ps.setString(5, form.getEvent_location());
			ps.setString(6, form.getDescription());
			ps.setDouble(7, form.getEvent_cost());
			ps.setInt(8, form.getGrading_format());
			ps.setString(9, form.getType_of_event());
			ps.setString(10, form.getJustification());
			ps.setString(11, form.getDepartment());
			ps.setInt(12, form.getGrade_type());
			ps.setDouble(13, form.getGrade());
			ps.setBoolean(14, form.isUrgent());
			ps.setBoolean(15, form.isDirect_supervisor_approved());
			ps.setBoolean(16, form.isDepartment_head_approved());
			ps.setBoolean(17, form.isBenefits_coordinator_approved());
			ps.setBoolean(18, form.isFinal_confirmation());
			ps.setBoolean(19, form.isDenied());
			
			ps.setInt(20, form.getForm_id());
			ps.execute();
			
			ps=conn.prepareStatement("commit");
			ps.execute();
			System.out.println("Successfully updated form");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	@Override
	public void removeForm(FormBean form) {
		Connection conn = cf.getConnection();
		String str1 = "delete from trms_forms where form_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(str1);
			ps.setInt(1, form.getForm_id());
			ps.execute();
			ps=conn.prepareStatement("commit");
			ps.execute();
			System.out.println("Form removed from database");
			if (ofdi.removeInfo(form.getForm_id())) {
				System.out.println("Optional info removed from database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void removeForm(int formID) {
		Connection conn = cf.getConnection();
		String str1 = "delete from trms_forms where form_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(str1);
			ps.setInt(1, formID);
			ps.execute();
			ps=conn.prepareStatement("commit");
			ps.execute();
			System.out.println("Form removed from database");
			if (ofdi.removeInfo(formID)) {
				System.out.println("Optional info removed from database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
