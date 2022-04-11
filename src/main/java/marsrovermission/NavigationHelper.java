package marsrovermission;

import marsrovermission.util.Direction;

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
}
