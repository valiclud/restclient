package cz.gemalto.rest;

import java.io.StringReader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import cz.gemalto.exception.JAXBAppExeption;
import cz.gemalto.exception.RestAppException;
import cz.gemalto.model.UserDetail;
import cz.gemalto.rest.iface.RestUserRequestIface;

/**
 * RestUserRequest class to process REST request
 * 
 * @author Ludvik Valicek - August 14 2015
 *
 */
public class RestUserRequest extends RestBaseRequest implements
		RestUserRequestIface {

	/**
	 * Logger for this class.
	 */
	static org.apache.log4j.Logger LOG = org.apache.log4j.Logger
			.getLogger(RestUserRequest.class.getName());

	private static RestUserRequest instance = null;

	private String xmlString;

	private RestUserRequest() {
	}

	/**
	 * Singleton instance.
	 * 
	 * @return RestUserRequest
	 */
	public static RestUserRequest getInstance() {
		if (instance == null) {
			synchronized (RestAuthenticateRequest.class) {
				if (instance == null) {
					instance = new RestUserRequest();
				}
			}
		}
		return instance;
	}

	/**
	 * Send REST user request.
	 * 
	 * @return REST response
	 */
	@Override
	public Response sendUserRequest(Cookie cookie) throws RestAppException {
		LOG.info("Sending REST GET message with cookie: " + cookie.toString());
		Client client = createRestClient();
		WebTarget target = client.target(getBaseURI()).path("saserver")
				.path("master").path("api").path("users").path("interview");
		Response response = target.request(MediaType.WILDCARD_TYPE)
				.cookie(cookie).get(Response.class);
		LOG.info("RECEIVED REST RESPONSE: " + response.toString());
		super.evaluateResponseStatus(response);
		this.setXmlString(response.readEntity(String.class));
		return response;

	}

	/**
	 * Create UserDetail JAXB object from String - implemented only for test
	 * purposes.
	 * 
	 * @return UserDetail
	 */
	@Override
	public UserDetail getUserDetailXMLFromString(String xmlString)
			throws JAXBAppExeption {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(UserDetail.class);
			Unmarshaller um = context.createUnmarshaller();
			StringReader sr = new StringReader(xmlString);
			return (UserDetail) um.unmarshal(sr);
		} catch (JAXBException e) {
			String err = "Subsystem exception occured during XML file creation.";
			LOG.error(err, e);
			throw new JAXBAppExeption(err, e);
		}
	}

	/**
	 * Get XML String reply.
	 * 
	 * @return String
	 */
	public String getXmlString() {
		return xmlString;
	}

	/**
	 * Set XML String reply.
	 * 
	 * @return void
	 */
	public void setXmlString(String xmlString) {
		this.xmlString = xmlString;
	}

}
