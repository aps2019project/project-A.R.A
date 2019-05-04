package Exceptions;

public class OpponentNotSelectedException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("select your opponent first");
    }
}
