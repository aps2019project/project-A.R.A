package Exceptions;

public class MainDeckNotSelectedException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("Main deck not selected");
    }
}
