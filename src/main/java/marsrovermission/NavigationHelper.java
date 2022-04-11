package marsrovermission;

import marsrovermission.util.Direction;
import marsrovermission.util.SpinDirection;

public class NavigationHelper {

    private static final NavigationHelper instance = new NavigationHelper();

    private NavigationHelper(){

    }

    public static NavigationHelper getInstance(){
        return instance;
    }

    public Position calculateNewPosition(Position roverPosition, int gridPoints){

        if (roverPosition.getOrientation() == Direction.N){
            roverPosition.setX(roverPosition.getX() + gridPoints);
        }
        else if (roverPosition.getOrientation() == Direction.E){
            roverPosition.setY(roverPosition.getY() + gridPoints);
        }
        else if (roverPosition.getOrientation() == Direction.S){
            roverPosition.setX(roverPosition.getX() - gridPoints);
        }
        else if (roverPosition.getOrientation() == Direction.W){
            roverPosition.setY(roverPosition.getY() - gridPoints);
        }
        return roverPosition;
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
