
package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;

import model.exception.RestAppException;
import rest.RestAuthenticateRequest;
import rest.RestUserRequest;
import rest.iface.RestUserRequestIface;


// TODO: Auto-generated Javadoc
/**
 * UserInfoServlet class to process HTTP request.
 *
 * @author Ludvik Valicek - August 14 2015
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new user info servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String url = "/userinfo.jsp";
		Response restResponse = null;

		RestUserRequestIface rur = RestUserRequest.getInstance();

		Cookie cookie = RestAuthenticateRequest.getInstance().getCookie();
		if (cookie != null) {
			try {
				restResponse = rur.sendUserRequest(cookie);
				request.setAttribute("userXML", rur.getXmlString());
			} catch (RestAppException e) {
				request.setAttribute("failed", e.getMessage());
				url = "/error.jsp";
			}
		} else {
			request.setAttribute("failed",	"Did not receive any cookie in REST reply");
			url = "/error.jsp";
		}

		// forward request and response objects to JSP page
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
