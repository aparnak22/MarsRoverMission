package marsrovermission;

public class Plateau {

    private final int maxX ;
    private final int maxY;
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;


    public Plateau(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public boolean isPositionInside(Position p) {
        return  MIN_X <= p.getX() && p.getX() <= maxX &&
                MIN_Y <= p.getY() && p.getY() <= maxY ;
    }
}
