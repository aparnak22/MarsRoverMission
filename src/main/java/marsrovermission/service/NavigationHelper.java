package marsrovermission.service;

import marsrovermission.model.Direction;
import marsrovermission.model.Position;
import marsrovermission.model.SpinDirection;

public class NavigationHelper {

    private static final NavigationHelper instance = new NavigationHelper();

    private NavigationHelper(){

    }

    public static NavigationHelper getInstance(){
        return instance;
    }

    public Position calculateNewPosition(Position roverPosition, int gridPoints){
        int newX = roverPosition.getX();
        int newY = roverPosition.getY();
        Direction orientation = roverPosition.getOrientation();
        if (roverPosition.getOrientation() == Direction.N){
            newY =  roverPosition.getY() + gridPoints;
        }
        else if (roverPosition.getOrientation() == Direction.E){
            newX = roverPosition.getX() + gridPoints;
        }
        else if (roverPosition.getOrientation() == Direction.S){
            newY = roverPosition.getY() - gridPoints;
        }
        else if (roverPosition.getOrientation() == Direction.W){
            newX = roverPosition.getX() - gridPoints;
        }
        return new Position(newX, newY, orientation);
    }

    public  Direction calculateNewSpinDirection(Position position, SpinDirection spinDirection){
        Direction newOrientation;
        int newOrientationDeg;
        if ( spinDirection == SpinDirection.L) {
            newOrientationDeg = position.getOrientation().getDegrees() - 90;
        }
        else {
            newOrientationDeg = position.getOrientation().getDegrees() + 90;
        }
        if ( newOrientationDeg >= 360 ) {
            newOrientationDeg = newOrientationDeg - 360;
        }
        else if (newOrientationDeg < 0 ){
            newOrientationDeg = newOrientationDeg + 360;
        }
        newOrientation = Direction.getDirection(newOrientationDeg);
        return newOrientation;
    }
}
