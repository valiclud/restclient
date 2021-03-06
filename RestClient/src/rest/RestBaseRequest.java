
package rest;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import model.exception.RestAppException;

// TODO: Auto-generated Javadoc
/**
 * RestBaseRequest class to process REST request.
 *
 * @author Ludvik Valicek - August 14 2015
 */
public class RestBaseRequest {

	/**
	 * Logger for this class.
	 */
	static org.apache.log4j.Logger LOG = org.apache.log4j.Logger
			.getLogger(RestBaseRequest.class.getName());

	
	/**
	 * Gets the base uri.
	 *
	 * @return the base uri
	 */
	protected java.net.URI getBaseURI() {
		return UriBuilder.fromUri(model.ApplicationConstants.url).build();
	}
	
	/**
	 * Creates the rest client.
	 *
	 * @return the javax.ws.rs.client. client
	 */
	protected javax.ws.rs.client.Client createRestClient(){
		ClientConfig config = new ClientConfig();
		return ClientBuilder.newClient(config);
	}
	
	/**
	 * Evaluate response status.
	 *
	 * @param response the response
	 * @throws RestAppException the rest app exception
	 */
	protected void evaluateResponseStatus(Response response) throws RestAppException {
		if (response == null){
			String err = " Server did not return any reply " ;
			LOG.error(err, null);
			throw new model.exception.RestAppException(err);
		}
		
		int status = response.getStatus();
		String error = "";

		switch (status) {
		case 200:
			return;
		case 400:
			error = "400 Bad Request";
			break;
		case 401:
			error = "401 Unauthorized";
			break;
		case 404:
			error = "404 Not Found";
			break;
		case 409:
			error = "409 Conflict";
			break;
		default:
			error = status + " Non identified server response";
			break;
		}

		String err = " Server returned error message: " + error;
		LOG.error(err, null);
		throw new model.exception.RestAppException(err);

	}
	
}
