package MyExceptions;

public class CodeException extends Exception{
    public CodeException() {
    }

    public CodeException(String message) {
        super("Fail! " + message);
    }
}
