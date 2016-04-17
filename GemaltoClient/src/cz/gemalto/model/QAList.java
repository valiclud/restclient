package cz.gemalto.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * QAList class to treat XML model
 * @author Ludvik Valicek - August 14 2015
 *
 */
@XmlRootElement(name = "QAList")
// If you want you can define the order in which the fields are written
// Optional
@XmlType(propOrder = { "locked", "retries" })
public class QAList {

	private boolean locked;
	private int retries;

	@XmlElement(name = "Locked")
	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@XmlElement(name = "Retries")
	public int getRetries() {
		return retries;
	}

	public void setRetries(int retries) {
		this.retries = retries;
	}

	@Override
	public String toString() {
		return "Password [locked=" + locked + ", retries=" + retries + "]";
	}

}
