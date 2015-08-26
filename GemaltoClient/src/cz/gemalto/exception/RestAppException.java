package cz.gemalto.exception;

/**
 * RestAppExeption class to treat application exception
 * @author Ludvik Valicek - August 14 2015
 *
 */
public class RestAppException extends java.lang.Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RestAppException(String s, Throwable c) {
        super(s,c);
    }
	
	public RestAppException(String s) {
        super(s);
    }

    public RestAppException(Throwable c) {
        super(c);
    }
}
