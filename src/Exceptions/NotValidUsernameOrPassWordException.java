package Exceptions;

public class NotValidUsernameOrPassWordException extends RuntimeException {
    @Override
    public void printStackTrace(){
        System.out.println("Username or PassWord is not valid");
    }
}
