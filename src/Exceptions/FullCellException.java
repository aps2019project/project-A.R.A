package Exceptions;

public class FullCellException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("selected cell has already a card or item");
    }
}
