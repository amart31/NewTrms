package com.revature.beans;

import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;

public class FormBean {
	int form_id;              // 1
	int employee_id;          // 2
	int direct_supervisor_id; // 3
	Date submit_date;         // 4
	Time submit_time;         // 5
	String event_location;    // 6
	String description;       // 7
	double event_cost;        // 8
	int grading_format;       // 9
	String type_of_event;     // 10
	String justification;     // 11
	String department;        // 12
	//this can be grade or present, pull from a reference table
	int grade_type;           // 13
	double grade;             // 14
	boolean urgent = false;   // 15
	boolean direct_supervisor_approved = false;      // 16
	boolean department_head_approved = false;        // 17
	boolean benefits_coordinator_approved = false;   // 18
	boolean final_confirmation = false;              // 19
	boolean denied = false;                          // 20
	
	ArrayList<OptionalFileBean> optionalFiles = new ArrayList<OptionalFileBean>();
	
	
	// This one has everything
	public FormBean(int form_id, int employee_id, int direct_supervisor_id, Date submit_date, Time submit_time, String event_location,
			String description, double event_cost, int grading_format, String type_of_event, String justification,
			String department, int grade_type, double grade, boolean urgent, boolean direct_supervisor_approved,
			boolean department_head_approved, boolean benefits_coordinator_approved, boolean final_confirmation, boolean denied) {
		super();
		this.form_id = form_id;
		this.employee_id = employee_id;
		this.direct_supervisor_id = direct_supervisor_id;
		this.submit_date = submit_date;
		this.submit_time = submit_time;
		this.event_location = event_location;
		this.description = description;
		this.event_cost = event_cost;
		this.grading_format = grading_format;
		this.type_of_event = type_of_event;
		this.justification = justification;
		this.department = department;
		this.grade_type = grade_type;
		this.grade = grade;
		this.urgent = urgent;
		this.direct_supervisor_approved = direct_supervisor_approved;
		this.department_head_approved = department_head_approved;
		this.benefits_coordinator_approved = benefits_coordinator_approved;
		this.final_confirmation = final_confirmation;
		this.denied = denied;
	}


	// This is commonly used for creating new objects
	public FormBean(int employee_id, int direct_supervisor_id, Date submit_date, Time submit_time, String event_location, String description,
			double event_cost, int grading_format, String type_of_event, String justification, String department,
			int grade_type) {
		super();
		this.employee_id = employee_id;
		this.direct_supervisor_id = direct_supervisor_id;
		this.submit_date = submit_date;
		this.submit_time = submit_time;
		this.event_location = event_location;
		this.description = description;
		this.event_cost = event_cost;
		this.grading_format = grading_format;
		this.type_of_event = type_of_event;
		this.justification = justification;
		this.department = department;
		this.grade_type = grade_type;
	}



	public int getForm_id() {
		return form_id;
	}



	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}



	public int getEmployee_id() {
		return employee_id;
	}



	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	

	public int getDirect_supervisor_id() {
		return direct_supervisor_id;
	}


	public void setDirect_supervisor_id(int direct_supervisor_id) {
		this.direct_supervisor_id = direct_supervisor_id;
	}


	public Date getSubmit_date() {
		return submit_date;
	}



	public void setSubmit_date(Date submit_date) {
		this.submit_date = submit_date;
	}



	public Time getSubmit_time() {
		return submit_time;
	}



	public void setSubmit_time(Time submit_time) {
		this.submit_time = submit_time;
	}



	public String getEvent_location() {
		return event_location;
	}



	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getEvent_cost() {
		return event_cost;
	}



	public void setEvent_cost(double event_cost) {
		this.event_cost = event_cost;
	}



	public int getGrading_format() {
		return grading_format;
	}



	public void setGrading_format(int grading_format) {
		this.grading_format = grading_format;
	}



	public String getType_of_event() {
		return type_of_event;
	}



	public void setType_of_event(String type_of_event) {
		this.type_of_event = type_of_event;
	}



	public String getJustification() {
		return justification;
	}



	public void setJustification(String justification) {
		this.justification = justification;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public int getGrade_type() {
		return grade_type;
	}



	public void setGrade_type(int grade_type) {
		this.grade_type = grade_type;
	}



	public double getGrade() {
		return grade;
	}



	public void setGrade(double grade) {
		this.grade = grade;
	}



	public boolean isUrgent() {
		return urgent;
	}



	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}



	public boolean isDirect_supervisor_approved() {
		return direct_supervisor_approved;
	}



	public void setDirect_supervisor_approved(boolean direct_supervisor_approved) {
		this.direct_supervisor_approved = direct_supervisor_approved;
	}



	public boolean isDepartment_head_approved() {
		return department_head_approved;
	}



	public void setDepartment_head_approved(boolean department_head_approved) {
		this.department_head_approved = department_head_approved;
	}



	public boolean isBenefits_coordinator_approved() {
		return benefits_coordinator_approved;
	}



	public void setBenefits_coordinator_approved(boolean benefits_coordinator_approved) {
		this.benefits_coordinator_approved = benefits_coordinator_approved;
	}



	public boolean isFinal_confirmation() {
		return final_confirmation;
	}



	public void setFinal_confirmation(boolean final_confirmation) {
		this.final_confirmation = final_confirmation;
	}



	public ArrayList<OptionalFileBean> getOptionalFiles() {
		return optionalFiles;
	}



	public void setOptionalFiles(ArrayList<OptionalFileBean> arrayList) {
		this.optionalFiles = arrayList;
	}

	public void addOptionalFile(OptionalFileBean optionalFile) {
		this.optionalFiles.add(optionalFile);
	}
	
	public void removeOptionalFile(OptionalFileBean optionalFile) {
		this.optionalFiles.remove(optionalFile);
	}


	
	public boolean isDenied() {
		return denied;
	}


	public void setDenied(boolean denied) {
		this.denied = denied;
	}


	@Override
	public String toString() {
		return "FormBean [form_id=" + form_id + ", employee_id=" + employee_id + ", submit_date=" + submit_date
				+ ", submit_time=" + submit_time + ", event_location=" + event_location + ", description=" + description
				+ ", event_cost=" + event_cost + ", grading_format=" + grading_format + ", type_of_event="
				+ type_of_event + ", justification=" + justification + ", department=" + department + ", grade_type="
				+ grade_type + ", grade=" + grade + ", urgent=" + urgent + ", direct_supervisor_approved="
				+ direct_supervisor_approved + ", department_head_approved=" + department_head_approved
				+ ", benefits_coordinator_approved=" + benefits_coordinator_approved + ", final_confirmation="
				+ final_confirmation + ", denied=" + denied + ", optionalFiles=" + optionalFiles + "]";
	}
	
	
	
	
	

}

