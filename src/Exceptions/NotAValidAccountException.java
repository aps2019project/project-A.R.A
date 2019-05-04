package Exceptions;

public class NotAValidAccountException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("chosen player is not in the list");
    }
}
