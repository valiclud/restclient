
package rest.iface;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;

import model.exception.JAXBAppExeption;
import model.exception.RestAppException;

// TODO: Auto-generated Javadoc
/**
 * RestAuthenticateRequestIface interface.
 *
 * @author Ludvik Valicek - August 14 2015
 */
public interface RestAuthenticateRequestIface {

	/**
	 * Send REST authenticate request.
	 *
	 * @param userID the user id
	 * @param password the password
	 * @return REST response
	 * @throws RestAppException the rest app exception
	 * @throws JAXBAppExeption the JAXB app exeption
	 */
	public Response sendAuthenticateRequest(String userID, String password) throws RestAppException, JAXBAppExeption;
	
	/**
	 * Get SessionID from REST Response.
	 *
	 * @param response the response
	 * @return String
	 */
	public Cookie getSessionIDFromResponse(javax.ws.rs.core.Response response);

	
}
