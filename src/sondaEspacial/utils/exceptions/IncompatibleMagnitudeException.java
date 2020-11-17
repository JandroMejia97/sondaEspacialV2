package sondaEspacial.utils.exceptions;

public class IncompatibleMagnitudeException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final static String MESSAGE = "¡ERROR! La operación no puede ser ejecutada.\n";

    public IncompatibleMagnitudeException(String message) {
        super(MESSAGE + message);
    }

    public IncompatibleMagnitudeException(String message, Throwable cause) {
        super(MESSAGE + message, cause);
    }

    public IncompatibleMagnitudeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(MESSAGE + message, cause, enableSuppression, writableStackTrace);
    }

}

