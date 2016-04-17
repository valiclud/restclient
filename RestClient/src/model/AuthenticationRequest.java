

package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// TODO: Auto-generated Javadoc
/**
 * AuthenticationRequest class to treat XML model.
 *
 * @author Ludvik Valicek - August 14 2015
 */
@XmlRootElement(name = "AuthenticationRequest")
//If you want you can define the order in which the fields are written
//Optional
@XmlType(propOrder = { "userID", "password", "openSession" })
public class AuthenticationRequest {
	
	/** The user id. */
	private String userID;
	
	/** The password. */
	private String password;
	
	/** The open session. */
	private boolean openSession;
	
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	@XmlElement(name = "UserID")
	public String getUserID() {
		return userID;
	}
	
	/**
	 * Sets the user id.
	 *
	 * @param userID the new user id
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@XmlElement(name = "Password")
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Checks if is open session.
	 *
	 * @return true, if is open session
	 */
	@XmlElement(name = "OpenSession")
	public boolean isOpenSession() {
		return openSession;
	}
	
	/**
	 * Sets the open session.
	 *
	 * @param openSession the new open session
	 */
	public void setOpenSession(boolean openSession) {
		this.openSession = openSession;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthenticationRequest [userID=" + userID + ", password="
				+ password + ", openSession=" + openSession + "]";
	}
	
	
	
}
