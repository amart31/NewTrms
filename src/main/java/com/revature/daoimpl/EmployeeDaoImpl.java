package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.EmployeeBean;
import com.revature.dao.EmployeeDao;
import com.revature.util.ConnFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public EmployeeBean getEmployee(int employeeID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM trms_employees WHERE employee_id = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, employeeID);
		ResultSet rs = ps.executeQuery();

		EmployeeBean employee = null;
		while (rs.next()) {
			employee = new EmployeeBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6),
					rs.getDouble(7));
		}

		return employee;
	}

	@Override
	public List<EmployeeBean> getAllEmployees() throws SQLException {
		List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();

		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM trms_employees");

		EmployeeBean employee = null;

		while (rs.next()) {
			employee = new EmployeeBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6),
					rs.getDouble(7));
			employeeList.add(employee);
		}
		return employeeList;
	}

	@Override
	public EmployeeBean employeeLogin(String username, String password) throws SQLException {
		// Retrieves the ConnFactory instance to create a database connection and creates an empty employee to store information
		Connection conn = cf.getConnection();
			EmployeeBean employee = new EmployeeBean();
								
				// Prepares the SQL resources
				String sql = "SELECT * FROM trms_employees WHERE username = ? AND employee_password = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
						
				//Puts the retrieved employee information into emp
				while(rs.next()) {
					employee.setEmployee_id(rs.getInt(1));
					employee.setUsername(rs.getString(2));
					employee.setEmployee_password(rs.getString(3));
					employee.setDirect_supervisor_id(rs.getInt(4));
					employee.setDepartment(rs.getString(5));
					employee.setPending_reimbursement(rs.getDouble(6));
					employee.setAwarded_reimbursement(rs.getDouble(7));
					employee.setDepartment_head(rs.getBoolean(8));;
					employee.setBenefits_coordinator(rs.getBoolean(9));
				}
						
				// Closes the database connection and returns emp
				conn.close();
				return employee;
	}

	@Override
	public List<EmployeeBean> getSubordinates(int employeeId) throws SQLException {
		// Retrieves the ConnFactory instance to create a database connection and
		// creates a list to store employees
		List<EmployeeBean> subordinatesList = new ArrayList<>();

		Connection conn = cf.getConnection();

		// Prepares the SQL resources
		String sql = "SELECT * FROM trms_employees WHERE direct_supervisor_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, employeeId);
		ResultSet rs = stmt.executeQuery();

		EmployeeBean employee = null;
		// Puts the retrieved employee information into employees
		while (rs.next()) {
			employee = new EmployeeBean(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getInt(4), rs.getString(5), rs.getDouble(6),
					rs.getDouble(7));
			subordinatesList.add(employee);
		}

		return subordinatesList;
	}

	// @Override
	// public boolean usernameExists(String username) throws SQLException {

	// return false;
	// }

	@Override
	public boolean correctPassword(String password, String username) throws SQLException {
		boolean match = false;
		ResultSet rs = null;

		String sql = "SELECT * FROM trms_employees WHERE employee_password = ? AND username = ?";
		Connection conn = cf.getConnection();

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, password);
		ps.setString(2, username);

		rs = ps.executeQuery();
		while (rs.next()) {
			if(password.equals(rs.getString("employee_password")) && username.equals(rs.getString("username"))) {
				match = true;
			} else {
				match = false;
			}
		}

		return match;
	}

	@Override
	public int getEmployeeId(String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT employee_id FROM trms_employees WHERE employee_password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}

	@Override
	public int createEmployee(EmployeeBean employee) throws SQLException {
		int employeesCreated = 0;
		String sql = "INSERT into trms_employees"
				+ " (employee_id, employee_password, direct_supervisor_id, department, pending_reimbursement, awarded_reimbursement, department_head, benefits_coordinator)"
				+ " VALUES (nextval(\'employee_seq\'), ?, ?, ?, ?, ?, ?, ?";

		Connection conn = cf.getConnection();

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, employee.getEmployee_password());
		ps.setInt(2, employee.getDirect_supervisor_id());
		ps.setString(3, employee.getDepartment());
		ps.setDouble(4, employee.getPending_reimbursement());
		ps.setDouble(5, employee.getAwarded_reimbursement());
		ps.setBoolean(6, employee.isDepartment_head());
		ps.setBoolean(7, employee.isBenefits_coordinator());

		ps.executeUpdate();

		return employeesCreated;
	}

	@Override
	public int updateEmployee(EmployeeBean employee) throws SQLException {
		int employeesUpdated = 0;

		String sql = "UPDATE trms_employees SET employee_password = ?  department = ? WHERE employee_id= ?";
		Connection conn = cf.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, employee.getEmployee_password());
		ps.setString(2, employee.getDepartment());
		ps.setInt(3, employee.getEmployee_id());

		employeesUpdated = ps.executeUpdate();

		return employeesUpdated;
	}

	@Override
	public int deleteEmployee(EmployeeBean employee) throws SQLException {
		int employeesDeleted = 0;
		Connection conn = cf.getConnection();

		String sql = "DELETE from trms_employees WHERE employee_id = ? AND department = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, employee.getEmployee_id());
		ps.setString(2, employee.getDepartment());

		employeesDeleted = ps.executeUpdate();
		ps = conn.prepareStatement("commit");
		ps.execute();
		return employeesDeleted;
	}

}
