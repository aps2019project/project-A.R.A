package Exceptions;

public class DuplicateHeroCardException extends CustomException{
    @Override
    public void printStackTrace(){
        System.out.println("there is a deck with this deck name ! ");
    }
}
