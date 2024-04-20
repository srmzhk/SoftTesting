package errandex;

public class FacultiyException extends Exception{
    public FacultiyException() {
    }

    public FacultiyException(String message) {
        super(message);
    }

    public FacultiyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacultiyException(Throwable cause) {
        super(cause);
    }

    public FacultiyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
