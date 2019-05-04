package Exceptions;

public class UnitNotFoundException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("unit not found");
    }
}
