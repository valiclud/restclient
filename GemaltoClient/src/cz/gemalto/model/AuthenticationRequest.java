package cz.gemalto.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * AuthenticationRequest class to treat XML model
 * @author Ludvik Valicek - August 14 2015
 *
 */
@XmlRootElement(name = "AuthenticationRequest")
//If you want you can define the order in which the fields are written
//Optional
@XmlType(propOrder = { "userID", "password", "openSession" })
public class AuthenticationRequest {
	
	private String userID;
	private String password;
	private boolean openSession;
	
	@XmlElement(name = "UserID")
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	@XmlElement(name = "Password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@XmlElement(name = "OpenSession")
	public boolean isOpenSession() {
		return openSession;
	}
	
	public void setOpenSession(boolean openSession) {
		this.openSession = openSession;
	}
	
	@Override
	public String toString() {
		return "AuthenticationRequest [userID=" + userID + ", password="
				+ password + ", openSession=" + openSession + "]";
	}
	
	
	
}
