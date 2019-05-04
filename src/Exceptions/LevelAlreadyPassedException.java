package Exceptions;

public class LevelAlreadyPassedException extends CustomException{
    @Override
    public void printStackTrace(){
        System.out.println("this level already passed");
    }
}
