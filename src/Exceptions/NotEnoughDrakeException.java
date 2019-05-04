package Exceptions;

public class NotEnoughDrakeException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("you dont have enough drake");
    }
}
