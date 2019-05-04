package Exceptions;

public class EnoughUnitExistsException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("this deck has enough units of this kind");
    }
}
