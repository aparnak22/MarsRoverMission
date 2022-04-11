package marsrovermission.app;

import marsrovermission.model.*;
import marsrovermission.service.NavigationHelper;

import java.util.ArrayList;
import java.util.List;

public class MissionControl {
    private final Plateau plateau;
    private final List<Rover> roverList;
    private int roverIdCounter = 0;
    private final static int MOVEMENT_GRID_POINTS = 1;

    public MissionControl(int gridSizeX,int gridSizeY) {
        plateau = new Plateau(gridSizeX, gridSizeY);
        roverList = new ArrayList<>();
    }

    public int createRover(int startX, int startY, Direction orientation){
        Rover rover = new Rover(roverIdCounter++,new Position(startX, startY, orientation));
        roverList.add(rover);
        return rover.getID();
    }

    public MoveOutcome moveRover(int roverID, String moveInstructions){
        Rover rover = roverList.get(roverID);
        for(int i=0; i< moveInstructions.length(); i++){
            char instruction = moveInstructions.charAt(i);
            if (instruction == 'M'){

                Position pos = NavigationHelper.getInstance().calculateNewPosition(
                        rover.getPosition(),MOVEMENT_GRID_POINTS);

                if (!plateau.isPositionInside(pos) ) {
                    return new MoveOutcome(false, rover.getPosition(), pos,
                            "Position is outside of Plateau bounds.");
                }
                if ( isObstructedForRover(roverID,pos)){
                    return new MoveOutcome(false,rover.getPosition(), pos,
                            "Position is obstructed by the other Rover.");
                }
               rover.moveRover(pos);
            }
            else{
                SpinDirection spinDirection = SpinDirection.valueOf(String.valueOf(instruction));
                Direction orientation = NavigationHelper.getInstance().calculateNewSpinDirection(
                                            rover.getPosition(),spinDirection);
                rover.spinRover(orientation);
            }
          /*  System.out.println("Rover "  +roverID + " " + rover.getPosition().getX() + " ,"+
                    rover.getPosition().getY() + " " + rover.getPosition().getOrientation());
                    */

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
