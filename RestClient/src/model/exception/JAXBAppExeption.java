
package model.exception;

// TODO: Auto-generated Javadoc
/**
 * JAXBAppExeption class to treat application exception.
 *
 * @author Ludvik Valicek - August 14 2015
 */
public class JAXBAppExeption extends java.lang.Exception {

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		/**
		 * Instantiates a new JAXB app exeption.
		 *
		 * @param s the s
		 * @param c the c
		 */
		public JAXBAppExeption(String s, Throwable c) {
	        super(s,c);
	    }
		
		/**
		 * Instantiates a new JAXB app exeption.
		 *
		 * @param s the s
		 */
		public JAXBAppExeption(String s) {
	        super(s);
	    }

	    /**
    	 * Instantiates a new JAXB app exeption.
    	 *
    	 * @param c the c
    	 */
    	public JAXBAppExeption(Throwable c) {
	        super(c);
	    }
	}
