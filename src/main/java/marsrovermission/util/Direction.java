package marsrovermission.util;

public enum Direction {
    N(0),E(90),S(180),W(270);


    private final int degrees;

    Direction(int degrees) {
        this.degrees = degrees;
    }

    public static Direction getDirection(int newOrientationDeg) {
        return switch (newOrientationDeg){
           case 0 -> N;
           case 90 -> E;
           case 180 -> S;
           case 270 -> W;
           default -> throw new IllegalStateException("Unexpected value: " + newOrientationDeg);
        };
    }

    public int getDegrees(){
        return this.degrees;
    }


}
