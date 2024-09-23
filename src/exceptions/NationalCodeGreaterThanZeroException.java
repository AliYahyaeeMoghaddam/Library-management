package exceptions;

public class NationalCodeGreaterThanZeroException extends Exception{
    public NationalCodeGreaterThanZeroException(){
        super("The entered national code must be greater than zero!");
    }
}
