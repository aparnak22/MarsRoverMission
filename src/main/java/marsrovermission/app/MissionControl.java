package marsrovermission.app;

import marsrovermission.model.*;
import marsrovermission.service.NavigationHelper;

import java.util.ArrayList;
import java.util.List;

public class MissionControl {
    public static final String OUTSIDE_OF_PLATEAU_BOUNDS = "Position is outside of Plateau bounds.";
    public static final String OBSTRUCTED_BY_ANOTHER_ROVER = "Position is obstructed by another Rover.";
    private final Plateau plateau;
//    private final List<Rover> roverList;
    private int roverIdCounter = 0;
    private final static int MOVEMENT_GRID_POINTS = 1;



    private MissionControl(int gridSizeX,int gridSizeY) {
        plateau = new Plateau(gridSizeX, gridSizeY);
    }


    public static MissionControl createMissionControlInstance(int gridSizeX, int gridSizeY){
        MissionControl missionControl = new MissionControl(gridSizeX, gridSizeY);
        return missionControl;
    }

    public int createRover(int startX, int startY, Direction orientation){
        if (plateau.isPositionInside(new Position(startX,startY,orientation))) {
            Rover rover = new Rover(roverIdCounter++, new Position(startX, startY, orientation));
            plateau.addRover(rover);
            return rover.getID();
        }
        else return -1;
    }

    public MoveOutcome moveRover(int roverID, String moveInstructions) {
        return plateau.moveRover(roverID,moveInstructions);
    }


}
