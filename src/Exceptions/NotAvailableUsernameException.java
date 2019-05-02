package Exceptions;

public class NotAvailableUsernameException extends RuntimeException {
    @Override
    public void printStackTrace(){
        System.out.println("Username Not Found");
    }
}
