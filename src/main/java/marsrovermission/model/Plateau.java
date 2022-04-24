package marsrovermission.model;

import marsrovermission.app.MoveOutcome;
import marsrovermission.service.NavigationHelper;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    public static final String OUTSIDE_OF_PLATEAU_BOUNDS = "Position is outside of Plateau bounds.";
    public static final String OBSTRUCTED_BY_ANOTHER_ROVER = "Position is obstructed by another Rover.";
    private final static int MOVEMENT_GRID_POINTS = 1;

    private final int maxX ;
    private final int maxY;
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;

    private final List<Rover> roverList = new ArrayList<>();

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

    public void addRover(Rover rover){
        roverList.add(rover);
    }

    public MoveOutcome moveRover(int roverID, String moveInstructions){
        Rover rover = roverList.get(roverID);
        for(int i=0; i< moveInstructions.length(); i++){
            char instruction = moveInstructions.charAt(i);
            if (instruction == 'M'){

                Position pos = NavigationHelper.getInstance().calculateNewPosition(
                        rover.getPosition(),MOVEMENT_GRID_POINTS);

                if (!isPositionInside(pos) ) {
                    return new MoveOutcome(false, rover.getPosition(), pos,
                            OUTSIDE_OF_PLATEAU_BOUNDS);
                }
                if ( isObstructedForRover(roverID,pos)){
                    return new MoveOutcome(false,rover.getPosition(), pos,
                            OBSTRUCTED_BY_ANOTHER_ROVER);
                }
                rover.moveRover(pos);
            }
            else{
                SpinDirection spinDirection = SpinDirection.valueOf(String.valueOf(instruction));
                Direction orientation = NavigationHelper.getInstance().calculateNewSpinDirection(
                        rover.getPosition(),spinDirection);
                rover.spinRover(orientation);
            }

        }
        return new MoveOutcome(true,rover.getPosition());
    }

    private boolean isObstructedForRover(int roverID, Position pos){
        for (Rover rover :roverList
        ) {
            if ( rover.getID()!=roverID ){
                if ( pos.getX() == rover.getPosition().getX() &&
                        pos.getY() == rover.getPosition().getY() ){
                    return true;
                }
            }
        }
        return false;
    }
}
