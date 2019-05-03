package Exceptions;

public class DuplicateDeckNameException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("there is a deck with this deck name ! ");
    }
}
