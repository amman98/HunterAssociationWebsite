package com.myproject.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myproject.beans.Hunter;
import com.myproject.services.HunterService;

@WebServlet("/editHunter")
public class EditHunterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int parsedId;

    public EditHunterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getParameter("id");
		
		parsedId = Integer.parseInt(id);
		
		Hunter hunter = null;
		
		HunterService dao = new HunterService();
		
		try {
			hunter = dao.findById(parsedId);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("hunter", hunter);
		
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/editHunter.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = (String)request.getParameter("firstName");
		String lastName = (String)request.getParameter("lastName");
		String nenAffinity = (String)request.getParameter("nenAffinity");
		String occupation = (String)request.getParameter("occupation");
		String status = (String)request.getParameter("status");
		String description = (String)request.getParameter("description");
		
		Hunter hunter = new Hunter();
		hunter.setId(parsedId);
		hunter.setFirstName(firstName);
		hunter.setLastName(lastName);
		hunter.setNenAffinity(nenAffinity);
		hunter.setOccupation(occupation);
		hunter.setStatus(status);
		hunter.setDescription(description);
		
		HunterService dao = new HunterService();
		
		try {
			dao.update(hunter);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("hunter", hunter);
		
		response.sendRedirect(request.getContextPath() + "/currentHunters");
	}

}
