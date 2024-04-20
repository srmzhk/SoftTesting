package MyExceptions;

public class RandomException extends Exception{
    public RandomException() {
    }

    public RandomException(String message) {
        super("Fail! " + message);
    }
}
