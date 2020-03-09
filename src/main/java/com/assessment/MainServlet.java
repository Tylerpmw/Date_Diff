// @author Tyler Montgomery

package com.assessment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet()
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public MainServlet() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setAttribute("input1", null);
		request.setAttribute("input2", null);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DateTime dt = new DateTime();
		String input1 = request.getParameter("input1");
		String input2 = request.getParameter("input2");
		dt.setUserInput(input1, input2);
		
		request.setAttribute("total", dt.toString(dt.run()));
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
}