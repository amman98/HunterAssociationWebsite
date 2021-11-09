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

@WebServlet("/deleteHunter")
public class DeleteHunterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int parsedId;   
	
    public DeleteHunterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getParameter("id");
		
		parsedId = Integer.parseInt(id);
		
		//Hunter hunter = null;
		
		HunterService dao = new HunterService();
		
		try {
			//hunter = dao.findById(parsedId);
			dao.delete(parsedId);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/currentHunters");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
