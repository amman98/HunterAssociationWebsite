package com.myproject.controller;

import java.util.ArrayList;
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

@WebServlet("/currentHunters")
public class CurrentHuntersListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CurrentHuntersListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HunterService dao = new HunterService();
		
		try {
			ArrayList<Hunter> hunters = dao.findAllAlive();
			request.setAttribute("hunters", hunters);
		}
		catch(SQLException e) {
			
		}
		
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/hunterList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
