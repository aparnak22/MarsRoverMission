package marsrovermission;

import marsrovermission.app.MissionControl;
import marsrovermission.app.MoveOutcome;
import marsrovermission.model.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMissionControl {

    @Test
    public void testCreateRover(){
        //plateau size 10, 10
        MissionControl mcontrol = new MissionControl(10,10);
        int roverID1 = mcontrol.createRover(2,2, Direction.N);
        int roverID2 = mcontrol.createRover(1,2, Direction.E);

        assertEquals(0,roverID1);
        assertEquals(1,roverID2);
    }

    @Test
    public void testMoveRoverWithOneInstruction() {
        //plateau size 10, 10
        MissionControl mcontrol = new MissionControl(10, 10);
        int roverID1 = mcontrol.createRover(2, 2, Direction.N);
        MoveOutcome result = mcontrol.moveRover(roverID1, "M");

        assertTrue(result.isSuccess());
        assertEquals(2,result.getEndPosition().getX());
        assertEquals(3,result.getEndPosition().getY());
        assertEquals(Direction.N,result.getEndPosition().getOrientation());
    }

    @Test
    public void testMoveRoverWithFiveInstructions(){
        //plateau size 10, 10
        MissionControl mcontrol = new MissionControl(10, 10);
        int roverID1 = mcontrol.createRover(2, 2, Direction.N);
        MoveOutcome result = mcontrol.moveRover(roverID1, "MLMLM");

        assertTrue(result.isSuccess());
        assertEquals(1,result.getEndPosition().getX());
        assertEquals(2,result.getEndPosition().getY());
        assertEquals(Direction.S,result.getEndPosition().getOrientation());
    }

    @Test
    public void testMoveRoverBriefSampleTest(){
        //plateau size 5, 5
        MissionControl mcontrol = new MissionControl(5,5);
        int roverID1 = mcontrol.createRover(1, 2, Direction.N);
        MoveOutcome result1 = mcontrol.moveRover(roverID1, "LMLMLMLMM");

        int roverID2 = mcontrol.createRover(3, 3, Direction.E);
        MoveOutcome result2 = mcontrol.moveRover(roverID2, "MMRMMRMRRM");

        assertTrue(result1.isSuccess());
        assertEquals(1,result1.getEndPosition().getX());
        assertEquals(3,result1.getEndPosition().getY());
        assertEquals(Direction.N,result1.getEndPosition().getOrientation());

        assertTrue(result2.isSuccess());
        assertEquals(5,result2.getEndPosition().getX());
        assertEquals(1,result2.getEndPosition().getY());
        assertEquals(Direction.E,result2.getEndPosition().getOrientation());
    }
}
