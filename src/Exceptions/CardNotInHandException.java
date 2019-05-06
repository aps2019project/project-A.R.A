package Exceptions;

public class CardNotInHandException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("you dont have this card in hand");
    }
}
