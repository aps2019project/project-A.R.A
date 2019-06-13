package Exceptions;

public class UseHeroSpecialPowerInvalidcoordinationException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("wrong coordination for use hero special power");
    }
}
