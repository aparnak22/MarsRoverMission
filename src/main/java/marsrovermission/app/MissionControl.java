package marsrovermission.app;

import marsrovermission.model.*;

public class MissionControl {
     private final Plateau plateau;
    private int roverIdCounter = 0;

    private MissionControl(int gridSizeX,int gridSizeY) {
        plateau = new Plateau(gridSizeX, gridSizeY);
    }

    public static MissionControl createMissionControlInstance(int gridSizeX, int gridSizeY){
       return new MissionControl(gridSizeX, gridSizeY);
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
