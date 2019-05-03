package Exceptions;

public class LvlNotAcheivedException extends RuntimeException {
    @Override
    public void printStackTrace(){
        System.out.println("you have to pass previous levels");
    }
}
