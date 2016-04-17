
package rest;

import java.io.StringWriter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.AuthenticationRequest;
import model.exception.JAXBAppExeption;
import model.exception.RestAppException;
import rest.iface.RestAuthenticateRequestIface;

	
// TODO: Auto-generated Javadoc
/**
 * RestAuthenticateRequest class to process REST request - synchronized singleton.
 *
 * @author Ludvik Valicek - August 14 2015
 */
public class RestAuthenticateRequest extends RestBaseRequest implements
		RestAuthenticateRequestIface {

	/**
	 * Logger for this class.
	 */
	static org.apache.log4j.Logger LOG = org.apache.log4j.Logger
			.getLogger(RestAuthenticateRequest.class.getName());

	/** The instance. */
	private static RestAuthenticateRequest instance = null;

	/** The cookie. */
	private Cookie cookie;

	/**
	 * Instantiates a new rest authenticate request.
	 */
	private RestAuthenticateRequest() {
	}

	/**
	 * Singleton instance.
	 * 
	 * @return RestAuthenticateRequest
	 */
	public static RestAuthenticateRequest getInstance() {
		if (instance == null) {
			synchronized (RestAuthenticateRequest.class) {
				if (instance == null) {
					instance = new RestAuthenticateRequest();
				}
			}
		}
		return instance;
	}

	/**
	 * Send REST authenticate request.
	 *
	 * @param userID the user id
	 * @param password the password
	 * @return REST response
	 * @throws RestAppException the rest app exception
	 * @throws JAXBAppExeption the JAXB app exeption
	 */
	@Override
	public Response sendAuthenticateRequest(String userID, String password) throws RestAppException, JAXBAppExeption {
		// create request
		AuthenticationRequest a = this.createAuthenticateRequest(userID, password);
		StringWriter sw = this.createXMLToSent(a);
		LOG.info("Sending REST POST message: " + sw.toString());

		Client client = this.createRestClient();
		WebTarget target = client.target(getBaseURI()).path("saserver").path("master").path("api").path("auth").path("pwd");

		Response response = target.request(MediaType.WILDCARD_TYPE).post(Entity.entity(sw.toString(), MediaType.TEXT_XML));
		super.evaluateResponseStatus(response);
		this.setCookie(response.getCookies().get("JSESSIONID").toCookie());
		LOG.info("RECEIVED REST RESPONSE: " + response.toString());
		return response;
	}

	/**
	 * Get SessionID from REST Response.
	 *
	 * @param response the response
	 * @return String
	 */
	@Override
	public Cookie getSessionIDFromResponse(Response response) {

		return response.getCookies().get("JSESSIONID").toCookie();
	}

	/**
	 * Create AuthenticationRequest object.
	 *
	 * @param userID the user id
	 * @param password the password
	 * @return AuthenticationRequest
	 */
	private AuthenticationRequest createAuthenticateRequest(String userID, String password) {
		AuthenticationRequest a = new AuthenticationRequest();
		a.setUserID(userID);
		a.setPassword(password);
		a.setOpenSession(model.ApplicationConstants.isOpenSession);

		return a;
	}

	/**
	 * Create XML from AuthenticationRequest object.
	 *
	 * @param ar the ar
	 * @return StringWriter
	 * @throws JAXBAppExeption the JAXB app exeption
	 */
	private StringWriter createXMLToSent(AuthenticationRequest ar) throws JAXBAppExeption {
		StringWriter sw = new StringWriter();
		sw.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

		// create JAXB context and instantiate marshaller
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(AuthenticationRequest.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			m.marshal(ar, sw);
		} catch (JAXBException e) {
			String err = "Subsystem exception occured during XML file creation.";
			LOG.error(err, e);
			throw new JAXBAppExeption(err, e);
		}

		return sw;
	}

	/**
	 * Get XML String reply.
	 * 
	 * @return String
	 */
	public Cookie getCookie() {
		return cookie;
	}

	/**
	 * Set XML String reply.
	 *
	 * @param cookie the new cookie
	 * @return void
	 */
	public void setCookie(Cookie cookie) {
		this.cookie = cookie;
	}

}
