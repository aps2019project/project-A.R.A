package Exceptions;

public class LevelAlreadyPassedException extends RuntimeException{
    @Override
    public void printStackTrace(){
        System.out.println("this level already passed");
    }
}
