package Exceptions;

public class WrongCommandException extends RuntimeException{
    @Override
    public void printStackTrace(){
        System.out.println("this command not supported");
    }
}
