package Exceptions;

public class CannotPutException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println(" cannot put");
    }

}
