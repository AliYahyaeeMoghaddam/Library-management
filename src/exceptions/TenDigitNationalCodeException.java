package exceptions;

public class TenDigitNationalCodeException extends Exception{
    public TenDigitNationalCodeException(){
        super("The entered national code must be ten digits long!");
    }
}
