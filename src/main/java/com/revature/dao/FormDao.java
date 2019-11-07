package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.FormBean;

public interface FormDao {
	public FormBean getForm(int formID);
	public ArrayList<FormBean> getAllForms();
	public ArrayList<FormBean> getFormsForSupervisor(int supID);
	public ArrayList<FormBean> getFormsForDepHead(String department);
	public ArrayList<FormBean> getFormsForCoordinator();
	public boolean uploadNewForm(FormBean form);
	public boolean updateForm(FormBean form);
	public void removeForm(FormBean form);
	public void removeForm(int formID);

}
