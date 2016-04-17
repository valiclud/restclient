package cz.gemalto.exception;

/**
 * JAXBAppExeption class to treat application exception
 * @author Ludvik Valicek - August 14 2015
 *
 */
public class JAXBAppExeption extends java.lang.Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JAXBAppExeption(String s, Throwable c) {
	        super(s,c);
	    }
		
		public JAXBAppExeption(String s) {
	        super(s);
	    }

	    public JAXBAppExeption(Throwable c) {
	        super(c);
	    }
	}
