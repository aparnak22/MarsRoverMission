package marsrovermission.model;

import marsrovermission.model.Direction;

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

    public void setOrientation( Direction orientation) {
        this.orientation = orientation;
    }

    public String toString(){
        return x + " " + y + " " +orientation.name();
    }
}
