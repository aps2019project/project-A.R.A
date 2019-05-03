package Exceptions;

public class WrongCommandException extends CustomException{
    @Override
    public void printStackTrace(){
        System.out.println("this command not supported");
    }
}
