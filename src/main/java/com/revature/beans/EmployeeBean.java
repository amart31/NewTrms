package com.revature.beans;

public class EmployeeBean {
	int employee_id;
	String username;
	String employee_password;
	// --email_address varchar(40), --delete this??
	int direct_supervisor_id;
	String department;
	double pending_reimbursement = 0.00;
	double awarded_reimbursement = 0.00;
	boolean department_head = false;
	boolean benefits_coordinator = false;

	public EmployeeBean() {
		super();
	}
	public EmployeeBean(String employee_password, int direct_supervisor_id) {
		super();
		this.employee_password = employee_password;
		this.direct_supervisor_id = direct_supervisor_id;
	}

	public EmployeeBean(int employee_id, String username, String employee_password, int direct_supervisor_id, String department,
			double pending_reimbursement, double awarded_reimbursement) {
		super();
		this.employee_id = employee_id;
		this.username = username;
		this.employee_password = employee_password;
		this.direct_supervisor_id = direct_supervisor_id;
		this.department = department;
		this.pending_reimbursement = pending_reimbursement;
		this.awarded_reimbursement = awarded_reimbursement;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmployee_password() {
		return employee_password;
	}

	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}

	public int getDirect_supervisor_id() {
		return direct_supervisor_id;
	}

	public void setDirect_supervisor_id(int direct_supervisor_id) {
		this.direct_supervisor_id = direct_supervisor_id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getPending_reimbursement() {
		return pending_reimbursement;
	}

	public void setPending_reimbursement(double pending_reimbursement) {
		this.pending_reimbursement = pending_reimbursement;
	}

	public double getAwarded_reimbursement() {
		return awarded_reimbursement;
	}

	public void setAwarded_reimbursement(double awarded_reimbursement) {
		this.awarded_reimbursement = awarded_reimbursement;
	}

	public boolean isDepartment_head() {
		return department_head;
	}

	public void setDepartment_head(boolean department_head) {
		this.department_head = department_head;
	}

	public boolean isBenefits_coordinator() {
		return benefits_coordinator;
	}

	public void setBenefits_coordinator(boolean benefits_coordinator) {
		this.benefits_coordinator = benefits_coordinator;
	}
	@Override
	public String toString() {
		return "EmployeeBean [employee_id=" + employee_id + ", username=" + username + ", employee_password="
				+ employee_password + ", direct_supervisor_id=" + direct_supervisor_id + ", department=" + department
				+ ", pending_reimbursement=" + pending_reimbursement + ", awarded_reimbursement="
				+ awarded_reimbursement + ", department_head=" + department_head + ", benefits_coordinator="
				+ benefits_coordinator + "]";
	}

	

}


