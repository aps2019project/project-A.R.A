package Exceptions;

public class LvlNotAcheivedException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("you have to pass previous levels");
    }
}
