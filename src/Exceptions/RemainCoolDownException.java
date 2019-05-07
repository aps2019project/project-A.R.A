package Exceptions;

public class RemainCoolDownException extends CustomException {
    @Override
    public void printStackTrace() {
        System.out.println("cool down remain");
    }
}
