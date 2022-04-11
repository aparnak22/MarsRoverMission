package marsrovermission;

import marsrovermission.util.Direction;
import marsrovermission.util.SpinDirection;

public class Position {
    private int x;
    private int y;
    private Direction orientation;

    public Position(int x, int y, Direction orientation){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getOrientation() {
        return orientation;
    }

    public Direction spin(SpinDirection spinDirection){
        Direction newOrientation;
        int newOrientationDeg;
        if ( spinDirection == SpinDirection.L) {
            newOrientationDeg = orientation.getDegrees() - 90;
        }
        else {
            newOrientationDeg = orientation.getDegrees() + 90;
        }
        if ( newOrientationDeg >= 360 ) {
            newOrientationDeg = newOrientationDeg - 360;
        }
        else if (newOrientationDeg < 0 ){
            newOrientationDeg = newOrientationDeg + 360;
        }
        newOrientation = Direction.getDirection(newOrientationDeg);
        orientation = newOrientation;
        return newOrientation;
    }

}
