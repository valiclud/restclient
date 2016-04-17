
package rest;

import java.io.StringReader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.UserDetail;
import model.exception.JAXBAppExeption;
import model.exception.RestAppException;
import rest.iface.RestUserRequestIface;


// TODO: Auto-generated Javadoc
/**
 * RestUserRequest class to process REST request.
 *
 * @author Ludvik Valicek - August 14 2015
 */
public class RestUserRequest extends RestBaseRequest implements
		RestUserRequestIface {

	/**
	 * Logger for this class.
	 */
	static org.apache.log4j.Logger LOG = org.apache.log4j.Logger
			.getLogger(RestUserRequest.class.getName());

	/** The instance. */
	private static RestUserRequest instance = null;

	/** The xml string. */
	private String xmlString;

	/**
	 * Instantiates a new rest user request.
	 */
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
	 * @param cookie the cookie
	 * @return REST response
	 * @throws RestAppException the rest app exception
	 */
	@Override
	public Response sendUserRequest(Cookie cookie) throws RestAppException {
		LOG.info("Sending REST GET message with cookie: " + cookie.toString());
		Client client = createRestClient();
		WebTarget target = client.target(super.getBaseURI()).path("saserver")
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
	 * @param xmlString the xml string
	 * @return UserDetail
	 * @throws JAXBAppExeption the JAXB app exeption
	 */
	@Override
	public UserDetail getUserDetailXMLFromString(String xmlString)
			throws JAXBAppExeption {
		JAXBContext context = null;
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
	 * @param xmlString the new xml string
	 * @return void
	 */
	public void setXmlString(String xmlString) {
		this.xmlString = xmlString;
	}

}
