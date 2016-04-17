
package model.exception;

// TODO: Auto-generated Javadoc
/**
 * RestAppExeption class to treat application exception.
 *
 * @author Ludvik Valicek - August 14 2015
 */
public class RestAppException extends java.lang.Exception {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new rest app exception.
	 *
	 * @param s the s
	 * @param c the c
	 */
	public RestAppException(String s, Throwable c) {
        super(s,c);
    }
	
	/**
	 * Instantiates a new rest app exception.
	 *
	 * @param s the s
	 */
	public RestAppException(String s) {
        super(s);
    }

    /**
     * Instantiates a new rest app exception.
     *
     * @param c the c
     */
    public RestAppException(Throwable c) {
        super(c);
    }
}
