package Exceptions;

public class HeroHasNotSpecilaPowerException extends CustomException {
    public void printStackTrace() {
        System.out.println("hero has not special power");
    }
}
