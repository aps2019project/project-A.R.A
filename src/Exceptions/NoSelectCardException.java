package Exceptions;

public class NoSelectCardException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("there is no selected card");
    }
}
