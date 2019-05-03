package Exceptions;

public class FullDeckException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("this deck is full !!");
    }
}
