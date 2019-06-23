package Exceptions;

public class CardNotFoundException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("card not found");
    }
}
