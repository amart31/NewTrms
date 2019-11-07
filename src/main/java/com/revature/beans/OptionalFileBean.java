package com.revature.beans;

public class OptionalFileBean {
	private int info_id;
	private int form_id;
	private String info_name;
	
	public OptionalFileBean(int info_id, int form_id, String info_name) {
		this.info_id=info_id;
		this.form_id=form_id;
		this.info_name=info_name;
	}
	
	public OptionalFileBean(int form_id, String info_name) {
		this.form_id=form_id;
		this.info_name=info_name;
	}

	public int getInfo_id() {
		return info_id;
	}

	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}

	public int getForm_id() {
		return form_id;
	}

	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}

	public String getInfo_name() {
		return info_name;
	}

	public void setInfo_name(String info_name) {
		this.info_name = info_name;
	}

	@Override
	public String toString() {
		return "OptionalFileBean [info_id=" + info_id + ", form_id=" + form_id + ", info_name=" + info_name + "]";
	}
	
	
	

}

