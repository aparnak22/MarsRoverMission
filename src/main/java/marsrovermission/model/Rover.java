package marsrovermission.model;

import marsrovermission.model.Direction;
import marsrovermission.model.Position;

public class Rover {

    private final int ID;
    private Position position;

    public Rover(int ID, Position position) {
        this.ID = ID;
        this.position = position;
    }

    public int getID(){
        return ID;
    }

    public Position getPosition(){
        return position;
    }

    public void moveRover(Position position){
        this.position = position;
    }

    public void spinRover(Direction orientation){
        this.position.setOrientation(orientation);
    }
}
