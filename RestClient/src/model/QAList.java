
package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// TODO: Auto-generated Javadoc
/**
 * QAList class to treat XML model.
 *
 * @author Ludvik Valicek - August 14 2015
 */
@XmlRootElement(name = "QAList")
// If you want you can define the order in which the fields are written
// Optional
@XmlType(propOrder = { "locked", "retries" })
public class QAList {

	/** The locked. */
	private boolean locked;
	
	/** The retries. */
	private int retries;

	/**
	 * Checks if is locked.
	 *
	 * @return true, if is locked
	 */
	@XmlElement(name = "Locked")
	public boolean isLocked() {
		return locked;
	}

	/**
	 * Sets the locked.
	 *
	 * @param locked the new locked
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * Gets the retries.
	 *
	 * @return the retries
	 */
	@XmlElement(name = "Retries")
	public int getRetries() {
		return retries;
	}

	/**
	 * Sets the retries.
	 *
	 * @param retries the new retries
	 */
	public void setRetries(int retries) {
		this.retries = retries;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Password [locked=" + locked + ", retries=" + retries + "]";
	}

}
