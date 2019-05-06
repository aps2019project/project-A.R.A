package Exceptions;

public class NoDeckExistsException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("There is no deck in the collection !");
    }
}
