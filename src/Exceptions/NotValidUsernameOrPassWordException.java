package Exceptions;

public class NotValidUsernameOrPassWordException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("Username or PassWord is not valid");
    }
}
