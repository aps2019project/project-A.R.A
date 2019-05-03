package Exceptions;

public class DeckNotFoundException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("there is no deck with this name !!");
    }
}
