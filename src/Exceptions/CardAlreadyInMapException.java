package Exceptions;

public class CardAlreadyInMapException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println(" this card exists already in map");
    }
}
