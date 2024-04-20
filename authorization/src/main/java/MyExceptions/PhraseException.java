package MyExceptions;

public class PhraseException extends Exception{
    public PhraseException() {
    }

    public PhraseException(String message) {
        super("Fail! " + message);
    }
}
