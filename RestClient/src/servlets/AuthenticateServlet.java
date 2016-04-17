
package servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.ws.rs.core.Response;

import rest.RestAuthenticateRequest;
import rest.iface.RestAuthenticateRequestIface;

import model.exception.*;


import javax.servlet.*;

// TODO: Auto-generated Javadoc
/**
 * AuthenticateServlet class to process HTTP request.
 *
 * @author Ludvik Valicek - August 14 2015
 */
@WebServlet("/AuthenticateServlet")
@MultipartConfig
// @MultipartConfig(location="C:/tmp", fileSizeThreshold=1024*1024,
// maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class AuthenticateServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger
			.getLogger(AuthenticateServlet.class.getCanonicalName());

	/**
	 * Instantiates a new authenticate servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticateServlet() {
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
//		doPost(request, response);
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

		 String url = "/login.jsp";
		 String userID = request.getParameter("username");
		 String password = request.getParameter("password");
		 Response respREST = null;
		 RestAuthenticateRequestIface rar =
		 RestAuthenticateRequest.getInstance();
		
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
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		 dispatcher.forward(request, response);
/*getServletContext().setInitParameter("jeden", "jeden");
		response.setContentType("text/html;charset=UTF-8");
		// Create path components to save the file
		final String path = request.getParameter("destination");
		final Part filePart = request.getPart("file");
		final String fileName = getFileName(filePart);
		OutputStream out = null;
		InputStream filecontent = null;
		final PrintWriter writer = response.getWriter();
		try {
			out = new FileOutputStream(new File(path + File.separator
					+ fileName));
			// File f = new File(fileName);
			// out = new FileOutputStream(f);
			filecontent = filePart.getInputStream();
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			// mam problem -> neyapise to na disk - > podivat se na internet
			// ServletInputStream sis = request.getInputStream();
			// while ((read = sis.read(bytes)) != -1) {
			// out.write(bytes, 0, read);
			// }
			writer.println("New file " + fileName + " created at " + path);
			LOGGER.log(Level.INFO, "File{0} being uploaded to {1}",
					new Object[] { fileName, path });
		} catch (FileNotFoundException fne) {
			writer.println("You either did not specify a file to upload or are "
					+ "trying to upload a file to a protected or nonexistent "
					+ "location.");
			writer.println("<br/> ERROR: " + fne.getMessage());
			LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
					new Object[] { fne.getMessage() });
		} finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
			if (writer != null) {
				writer.close();
			} */
		}

	//}

	/**
	 * Gets the file name.
	 *
	 * @param part the part
	 * @return the file name
	 */
	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=") + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}
