package com.revature.dao;

import java.util.ArrayList;

import com.revature.beans.OptionalFileBean;

public interface OptionalFileDao {
	public OptionalFileBean getOneFile(int infoID);
	public ArrayList<OptionalFileBean> getFiles(int formID);
	public boolean uploadNewFile(OptionalFileBean of);
	public int uploadNewFile(int formID, String infoName);
	public boolean removeInfo(int formID);
	public boolean removeInfo(OptionalFileBean file);

}