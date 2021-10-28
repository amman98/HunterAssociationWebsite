package com.myproject.controller;

import java.io.IOException;
import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.beans.Hunter;
import com.myproject.services.HunterService;

/**
 * Servlet implementation class AddHunterServlet
 */
@WebServlet("/addHunter")
public class AddHunterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHunterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/addHunter.jsp");
		dispatcher.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = (String)request.getParameter("firstName");
		String lastName = (String)request.getParameter("lastName");
		String nenAffinity = (String)request.getParameter("nenAffinity");
		String occupation = (String)request.getParameter("occupation");
		String status = (String)request.getParameter("status");
		String description = (String)request.getParameter("description");

		Hunter hunter = new Hunter();
		hunter.setFirstName(firstName);
		hunter.setLastName(lastName);
		hunter.setNenAffinity(nenAffinity);
		hunter.setOccupation(occupation);
		hunter.setStatus(status);
		hunter.setDescription(description);
		
		/*
		 * if no errors in provided input in addHunter.jsp,
		 * call HunterService.save(hunter) and redirect to
		 * list of hunters page. 
		 * Otherwise, redirect back to addHunter.jsp to reprompt
		 * user.
		 */
		
		HunterService service = new HunterService();
		
		try {
			service.save(hunter);
			response.sendRedirect(request.getContextPath() + "/currentHunters");
		} catch(SQLException e) {
			System.out.println("First name has already been used.");
			//e.printStackTrace();
		}
		
		
	}

}
