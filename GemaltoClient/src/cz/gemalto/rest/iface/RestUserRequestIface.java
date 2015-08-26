package cz.gemalto.rest.iface;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;

import cz.gemalto.exception.JAXBAppExeption;
import cz.gemalto.exception.RestAppException;
import cz.gemalto.model.UserDetail;

/**
 * RestUserRequestIface interface
 * @author Ludvik Valicek - August 14 2015
 *
 */
public interface RestUserRequestIface {

	/**
     * Send REST user request.
     * 
     * @return REST response
     */
	public Response sendUserRequest(Cookie cookie) throws RestAppException;

	/**
     * Create UserDetail JAXB object from String.
     * 
     * @return UserDetail
     */
	public UserDetail getUserDetailXMLFromString(String xmlString) throws JAXBAppExeption;
	
	/**
     * Get XML String reply.
     * 
     * @return String
     */
	public String getXmlString();
	
}
