package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.EmployeeBean;
import com.revature.daoimpl.EmployeeDaoImpl;


public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("account.html").forward(request, response);
		System.out.println("in do get");
		ObjectMapper mapper = new ObjectMapper();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		
		int id = mapper.readValue(request.getParameter("employee_id"), Integer.class);
		PrintWriter out=response.getWriter();
		String accountJSON;
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost of AccountServlet");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("account.html").include(request, response);
		
	}

}
