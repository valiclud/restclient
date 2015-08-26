package cz.gemalto.rest.iface;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;

import cz.gemalto.exception.JAXBAppExeption;
import cz.gemalto.exception.RestAppException;

/**
 * RestAuthenticateRequestIface interface
 * @author Ludvik Valicek - August 14 2015
 *
 */
public interface RestAuthenticateRequestIface {

	/**
	 * Send REST authenticate request.
	 * 
	 * @return REST response
	 */
	public Response sendAuthenticateRequest(String userID, String password) throws RestAppException, JAXBAppExeption;
	
	/**
     * Get SessionID from REST Response.
     * 
     * @return String
     */
	public Cookie getSessionIDFromResponse(javax.ws.rs.core.Response response);

	
}
