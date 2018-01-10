package com.nachattar.simulator.commandexecution.loader;


/**
 * The class <code>YAMLLoaderException</code> is a form of 
 * <code>Throwable</code> that indicates conditions that has arrised 
 * while loading an yaml file which contains commands information that application might want to catch.
 *
 * @author  Deed Singh (deedsing)
 * @version %I%, %G%
 * @see     java.lang.Error
 */
public class YAMLLoaderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1688968264104877951L;

	 /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
        public YAMLLoaderException(String message){
                super(message);
        }



    /**
     * Constructs a new exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * <code>cause</code> is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * 
     */
    public YAMLLoaderException(String message, Throwable cause) {
        super(message, cause);
    }

}
