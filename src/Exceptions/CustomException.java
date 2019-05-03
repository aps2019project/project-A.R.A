package Exceptions;

public class CustomException extends RuntimeException {
    @Override
    public void printStackTrace(){
        System.out.println("Username Not Found");
    }
}
