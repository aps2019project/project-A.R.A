package Exceptions;

public class NotAvailableUsernameException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("Username Not Found");
    }
}
