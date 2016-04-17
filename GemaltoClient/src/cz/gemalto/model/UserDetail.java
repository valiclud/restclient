package cz.gemalto.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * UserDetail class to treat XML model
 * @author Ludvik Valicek - August 14 2015
 *
 */
@XmlRootElement(name = "User")
// If you want you can define the order in which the fields are written
// Optional
@XmlType(propOrder = { "userID", "state", "confirmedAccount", "role",
		"firstName", "lastName", "msisdn", "email", "password", "qaList",
		"tokenList", "creationDate", "modifDate", "deviceRetries" })
public class UserDetail {

	private String userID;
	private String state;
	private boolean confirmedAccount;
	private String role;
	private String firstName;
	private String lastName;
	private String msisdn;
	private String email;
	private java.util.List <Password> password;
	private java.util.List <QAList> qaList;
	private java.util.List <TokenList> tokenList;
	private java.util.Date creationDate;
	private java.util.Date modifDate;
	private int deviceRetries;

	@XmlElement(name = "UserID")
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	@XmlElement(name = "State")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@XmlElement(name = "ConfirmedAccount")
	public boolean isConfirmedAccount() {
		return confirmedAccount;
	}

	public void setConfirmedAccount(boolean confirmedAccount) {
		this.confirmedAccount = confirmedAccount;
	}

	@XmlElement(name = "Role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@XmlElement(name = "FirstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@XmlElement(name = "LastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlElement(name = "MSISDN")
	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	@XmlElement(name = "Email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement(name = "Password")
	public List <Password> getPassword() {
		return password;
	}

	public void setPassword(List <Password> password) {
		this.password = password;
	}

	@XmlElement(name = "QAList")
	public List <QAList> getQaList() {
		return qaList;
	}

	public void setQaList( List <QAList> qaList) {
		this.qaList = qaList;
	}

	@XmlElement(name = "TokenList")
	public List <TokenList> getTokenList() {
		return tokenList;
	}

	public void setTokenList(List <TokenList> tokenList) {
		this.tokenList = tokenList;
	}

	@XmlElement(name = "CreationDate")
	public java.util.Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(java.util.Date creationDate) {
		this.creationDate = creationDate;
	}

	@XmlElement(name = "ModifDate")
	public java.util.Date getModifDate() {
		return modifDate;
	}

	public void setModifDate(java.util.Date modifDate) {
		this.modifDate = modifDate;
	}

	@XmlElement(name = "DeviceRetries")
	public int getDeviceRetries() {
		return deviceRetries;
	}

	public void setDeviceRetries(int deviceRetries) {
		this.deviceRetries = deviceRetries;
	}

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
