
package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// TODO: Auto-generated Javadoc
/**
 * TokenList class to treat XML model.
 *
 * @author Ludvik Valicek - August 14 2015
 */
@XmlRootElement(name = "TokenList")
// If you want you can define the order in which the fields are written
// Optional
@XmlType(propOrder = { "oathToken", "otbToken", "emvToken", "mobileToken" })
public class TokenList {

	/** The oath token. */
	private String oathToken;
	
	/** The otb token. */
	private String otbToken;
	
	/** The emv token. */
	private String emvToken;
	
	/** The mobile token. */
	private String mobileToken;

	/**
	 * Gets the oath token.
	 *
	 * @return the oath token
	 */
	@XmlElement(name = "OathToken")
	public String getOathToken() {
		return oathToken;
	}

	/**
	 * Sets the oath token.
	 *
	 * @param oathToken the new oath token
	 */
	public void setOathToken(String oathToken) {
		this.oathToken = oathToken;
	}

	/**
	 * Gets the otb token.
	 *
	 * @return the otb token
	 */
	@XmlElement(name = "OtbToken")
	public String getOtbToken() {
		return otbToken;
	}

	/**
	 * Sets the otb token.
	 *
	 * @param otbToken the new otb token
	 */
	public void setOtbToken(String otbToken) {
		this.otbToken = otbToken;
	}

	/**
	 * Gets the emv token.
	 *
	 * @return the emv token
	 */
	@XmlElement(name = "EmvToken")
	public String getEmvToken() {
		return emvToken;
	}

	/**
	 * Sets the emv token.
	 *
	 * @param emvToken the new emv token
	 */
	public void setEmvToken(String emvToken) {
		this.emvToken = emvToken;
	}

	/**
	 * Gets the mobile token.
	 *
	 * @return the mobile token
	 */
	@XmlElement(name = "MobileToken")
	public String getMobileToken() {
		return mobileToken;
	}

	/**
	 * Sets the mobile token.
	 *
	 * @param mobileToken the new mobile token
	 */
	public void setMobileToken(String mobileToken) {
		this.mobileToken = mobileToken;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TokenList [oathToken=" + oathToken + ", otbToken=" + otbToken
				+ ", emvToken=" + emvToken + ", mobileToken=" + mobileToken
				+ "]";
	}

}
