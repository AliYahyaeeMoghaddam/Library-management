package exceptions;

public class AccountException extends Exception{
    public AccountException(Exception e){
        super(e);
    }
}
