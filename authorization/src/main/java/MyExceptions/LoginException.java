package MyExceptions;

public class LoginException extends Exception{
    public LoginException() {
    }

    public LoginException(String message) {
        super("Fail! " + message);
    }
}
