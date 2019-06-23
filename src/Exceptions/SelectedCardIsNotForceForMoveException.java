package Exceptions;

public class SelectedCardIsNotForceForMoveException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("please select force for move");
    }
}
