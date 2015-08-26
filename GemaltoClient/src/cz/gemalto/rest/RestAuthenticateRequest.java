package cz.gemalto.rest;

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

import cz.gemalto.exception.JAXBAppExeption;
import cz.gemalto.exception.RestAppException;
import cz.gemalto.model.AuthenticationRequest;
import cz.gemalto.rest.iface.RestAuthenticateRequestIface;

/**
 * RestAuthenticateRequest class to process REST request
 * 
 * @author Ludvik Valicek - August 14 2015
 *
 */
public class RestAuthenticateRequest extends RestBaseRequest implements
		RestAuthenticateRequestIface {

	/**
	 * Logger for this class.
	 */
	static org.apache.log4j.Logger LOG = org.apache.log4j.Logger
			.getLogger(RestAuthenticateRequest.class.getName());

	private static RestAuthenticateRequest instance = null;

	private Cookie cookie;

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
	 * @return REST response
	 */
	@Override
	public Response sendAuthenticateRequest(String userID, String password)
			throws RestAppException, JAXBAppExeption {
		// create request
		AuthenticationRequest a = createAuthenticateRequest(userID, password);
		StringWriter sw = createXMLToSent(a);
		LOG.info("Sending REST POST message: " + sw.toString());

		Client client = createRestClient();
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
	 * @return String
	 */
	@Override
	public Cookie getSessionIDFromResponse(Response response) {

		return response.getCookies().get("JSESSIONID").toCookie();
	}

	/**
	 * Create AuthenticationRequest object.
	 * 
	 * @return AuthenticationRequest
	 */
	private AuthenticationRequest createAuthenticateRequest(String userID, String password) {
		AuthenticationRequest a = new AuthenticationRequest();
		a.setUserID(userID);
		a.setPassword(password);
		a.setOpenSession(cz.gemalto.model.ApplicationConstants.isOpenSession);

		return a;
	}

	/**
	 * Create XML from AuthenticationRequest object.
	 * 
	 * @return StringWriter
	 */
	private StringWriter createXMLToSent(AuthenticationRequest ar) throws JAXBAppExeption {
		StringWriter sw = new StringWriter();
		sw.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

		// create JAXB context and instantiate marshaller
		JAXBContext context;
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
	 * @return void
	 */
	public void setCookie(Cookie cookie) {
		this.cookie = cookie;
	}

}
