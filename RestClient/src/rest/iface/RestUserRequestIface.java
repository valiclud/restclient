
package rest.iface;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;

import model.exception.JAXBAppExeption;
import model.exception.RestAppException;
import model.UserDetail;

// TODO: Auto-generated Javadoc
/**
 * RestUserRequestIface interface.
 *
 * @author Ludvik Valicek - August 14 2015
 */
public interface RestUserRequestIface {

	/**
	 * Send REST user request.
	 *
	 * @param cookie the cookie
	 * @return REST response
	 * @throws RestAppException the rest app exception
	 */
	public Response sendUserRequest(Cookie cookie) throws RestAppException;

	/**
	 * Create UserDetail JAXB object from String.
	 *
	 * @param xmlString the xml string
	 * @return UserDetail
	 * @throws JAXBAppExeption the JAXB app exeption
	 */
	public UserDetail getUserDetailXMLFromString(String xmlString) throws JAXBAppExeption;
	
	/**
     * Get XML String reply.
     * 
     * @return String
     */
	public String getXmlString();
	
}
