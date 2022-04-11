package marsrovermission.util;

public enum SpinDirection {
    L(90) , R(90);

    private final int degrees;

    SpinDirection(int degrees) {
        this.degrees = degrees;
    }
}
