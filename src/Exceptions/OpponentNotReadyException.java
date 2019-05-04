package Exceptions;

public class OpponentNotReadyException  extends CustomException{
    @Override
    public void printStackTrace(){
        System.out.println("selected deck for second player is invalid");
    }
}
