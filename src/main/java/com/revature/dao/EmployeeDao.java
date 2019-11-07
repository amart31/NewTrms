package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.EmployeeBean;

public interface EmployeeDao {
	public EmployeeBean getEmployee(int employeeID) throws SQLException;
	public List<EmployeeBean> getAllEmployees()throws SQLException;
	
	public int createEmployee(EmployeeBean employee) throws SQLException;
	public int updateEmployee(EmployeeBean employee) throws SQLException;
	public int deleteEmployee(EmployeeBean employee) throws SQLException;
	
	public EmployeeBean employeeLogin(String username, String password) throws SQLException;
	
	//used for supervisorsand dept heads to get those under them
	public List<EmployeeBean> getSubordinates(int employeeId) throws SQLException;
	
	//public boolean usernameExists(String username) throws SQLException;
	public boolean correctPassword(String password, String username) throws SQLException;
	public int getEmployeeId(String username) throws SQLException;

}
