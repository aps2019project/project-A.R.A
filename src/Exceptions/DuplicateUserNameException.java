package Exceptions;

public class DuplicateUserNameException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("username already exists. choose another userName");
    }
}
