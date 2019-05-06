package Exceptions;

public class ThePathIsBlockedException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("the path is blocked");
    }
}
