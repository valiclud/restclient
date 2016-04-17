package cz.gemalto.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import cz.gemalto.exception.JAXBAppExeption;
import cz.gemalto.exception.RestAppException;
import cz.gemalto.rest.RestAuthenticateRequest;
import cz.gemalto.rest.iface.RestAuthenticateRequestIface;

/**
 * AuthenticateServlet class to process HTTP request
 * 
 * @author Ludvik Valicek - August 14 2015
 *
 */
@WebServlet("/AuthenticateServlet")
public class AuthenticateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userID = request.getParameter("username");
		String password = request.getParameter("password");
		String url = null;
		Response respREST = null;

		RestAuthenticateRequestIface rar = RestAuthenticateRequest.getInstance();

		try {
			respREST = rar.sendAuthenticateRequest(userID, password);
		} catch (RestAppException | JAXBAppExeption e) {
			request.setAttribute("failed", e.getMessage()
					+ " - possible wrong usedID / password was inserted");
			url = "/error.jsp";
		}

		if (respREST != null) {
			url = "/login.jsp";
		}
		// forward request and response objects to JSP page
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
