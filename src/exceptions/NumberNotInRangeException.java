package exceptions;

public class NumberNotInRangeException extends Exception
{
    public NumberNotInRangeException(String message) {
        super(message);
    }
}