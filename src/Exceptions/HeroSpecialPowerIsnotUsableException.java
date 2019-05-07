package Exceptions;

public class HeroSpecialPowerIsnotUsableException extends CustomException {
    @Override
    public void printStackTrace() {
        System.out.println("Hero special power is not usable");
    }
}
