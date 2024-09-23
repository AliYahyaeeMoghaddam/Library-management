package exceptions;

public class LettersBetweenFiveAndSixtyFourException extends Exception{
    public LettersBetweenFiveAndSixtyFourException(){
        super("The letters of the entered name must be between five and sixty-four characters!");
    }
}
