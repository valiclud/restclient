
package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// TODO: Auto-generated Javadoc
/**
 * UserDetail class to treat XML model.
 *
 * @author Ludvik Valicek - August 14 2015
 */
@XmlRootElement(name = "User")
// If you want you can define the order in which the fields are written
// Optional
@XmlType(propOrder = { "userID", "state", "confirmedAccount", "role",
		"firstName", "lastName", "msisdn", "email", "password", "qaList",
		"tokenList", "creationDate", "modifDate", "deviceRetries" })
public class UserDetail {

	/** The user id. */
	private String userID;
	
	/** The state. */
	private String state;
	
	/** The confirmed account. */
	private boolean confirmedAccount;
	
	/** The role. */
	private String role;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The msisdn. */
	private String msisdn;
	
	/** The email. */
	private String email;
	
	/** The password. */
	private java.util.List <Password> password;
	
	/** The qa list. */
	private java.util.List <QAList> qaList;
	
	/** The token list. */
	private java.util.List <TokenList> tokenList;
	
	/** The creation date. */
	private java.util.Date creationDate;
	
	/** The modif date. */
	private java.util.Date modifDate;
	
	/** The device retries. */
	private int deviceRetries;

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
	 * Gets the state.
	 *
	 * @return the state
	 */
	@XmlElement(name = "State")
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Checks if is confirmed account.
	 *
	 * @return true, if is confirmed account
	 */
	@XmlElement(name = "ConfirmedAccount")
	public boolean isConfirmedAccount() {
		return confirmedAccount;
	}

	/**
	 * Sets the confirmed account.
	 *
	 * @param confirmedAccount the new confirmed account
	 */
	public void setConfirmedAccount(boolean confirmedAccount) {
		this.confirmedAccount = confirmedAccount;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	@XmlElement(name = "Role")
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	@XmlElement(name = "FirstName")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	@XmlElement(name = "LastName")
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the msisdn.
	 *
	 * @return the msisdn
	 */
	@XmlElement(name = "MSISDN")
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * Sets the msisdn.
	 *
	 * @param msisdn the new msisdn
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	@XmlElement(name = "Email")
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@XmlElement(name = "Password")
	public List <Password> getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(List <Password> password) {
		this.password = password;
	}

	/**
	 * Gets the qa list.
	 *
	 * @return the qa list
	 */
	@XmlElement(name = "QAList")
	public List <QAList> getQaList() {
		return qaList;
	}

	/**
	 * Sets the qa list.
	 *
	 * @param qaList the new qa list
	 */
	public void setQaList( List <QAList> qaList) {
		this.qaList = qaList;
	}

	/**
	 * Gets the token list.
	 *
	 * @return the token list
	 */
	@XmlElement(name = "TokenList")
	public List <TokenList> getTokenList() {
		return tokenList;
	}

	/**
	 * Sets the token list.
	 *
	 * @param tokenList the new token list
	 */
	public void setTokenList(List <TokenList> tokenList) {
		this.tokenList = tokenList;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	@XmlElement(name = "CreationDate")
	public java.util.Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate the new creation date
	 */
	public void setCreationDate(java.util.Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the modif date.
	 *
	 * @return the modif date
	 */
	@XmlElement(name = "ModifDate")
	public java.util.Date getModifDate() {
		return modifDate;
	}

	/**
	 * Sets the modif date.
	 *
	 * @param modifDate the new modif date
	 */
	public void setModifDate(java.util.Date modifDate) {
		this.modifDate = modifDate;
	}

	/**
	 * Gets the device retries.
	 *
	 * @return the device retries
	 */
	@XmlElement(name = "DeviceRetries")
	public int getDeviceRetries() {
		return deviceRetries;
	}

	/**
	 * Sets the device retries.
	 *
	 * @param deviceRetries the new device retries
	 */
	public void setDeviceRetries(int deviceRetries) {
		this.deviceRetries = deviceRetries;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDetail [userID=" + userID + ", state=" + state
				+ ", confirmedAccount=" + confirmedAccount + ", role=" + role
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", msisdn=" + msisdn + ", email=" + email + ", password="
				+ password + ", qaList=" + qaList + ", tokenList=" + tokenList
				+ ", creationDate=" + creationDate + ", modifDate=" + modifDate
				+ ", deviceRetries=" + deviceRetries + "]";
	}

	
	
}
