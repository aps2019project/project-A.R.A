package Exceptions;

public class fullItemException extends CustomException{
    @Override
    public void printStackTrace(){
        System.out.println("you cant have more Items");
    }
}
