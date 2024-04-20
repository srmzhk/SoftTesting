package MyExceptions;

public class PasswordException extends Exception{
    public PasswordException() {
    }

    public PasswordException(String message) {
        super("Fail! " + message);
    }
}
