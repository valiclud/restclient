package cz.gemalto.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * TokenList class to treat XML model
 * @author Ludvik Valicek - August 14 2015
 *
 */
@XmlRootElement(name = "TokenList")
// If you want you can define the order in which the fields are written
// Optional
@XmlType(propOrder = { "oathToken", "otbToken", "emvToken", "mobileToken" })
public class TokenList {

	private String oathToken;
	private String otbToken;
	private String emvToken;
	private String mobileToken;

	@XmlElement(name = "OathToken")
	public String getOathToken() {
		return oathToken;
	}

	public void setOathToken(String oathToken) {
		this.oathToken = oathToken;
	}

	@XmlElement(name = "OtbToken")
	public String getOtbToken() {
		return otbToken;
	}

	public void setOtbToken(String otbToken) {
		this.otbToken = otbToken;
	}

	@XmlElement(name = "EmvToken")
	public String getEmvToken() {
		return emvToken;
	}

	public void setEmvToken(String emvToken) {
		this.emvToken = emvToken;
	}

	@XmlElement(name = "MobileToken")
	public String getMobileToken() {
		return mobileToken;
	}

	public void setMobileToken(String mobileToken) {
		this.mobileToken = mobileToken;
	}

	@Override
	public String toString() {
		return "TokenList [oathToken=" + oathToken + ", otbToken=" + otbToken
				+ ", emvToken=" + emvToken + ", mobileToken=" + mobileToken
				+ "]";
	}

}
