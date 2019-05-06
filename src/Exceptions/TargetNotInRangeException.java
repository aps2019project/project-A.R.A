package Exceptions;

public class TargetNotInRangeException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("this card cant move upto this distance");
    }
}
