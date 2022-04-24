package marsrovermission;

import marsrovermission.app.MissionControl;
import marsrovermission.app.MoveOutcome;
import marsrovermission.model.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMissionControl {

    @Test
    public void testCreateRover(){
        //plateau size 10, 10
        MissionControl mcontrol =  MissionControl.createMissionControlInstance(10,10);
        int roverID1 = mcontrol.createRover(2,2, Direction.N);
        int roverID2 = mcontrol.createRover(1,2, Direction.E);

        assertEquals(0,roverID1);
        assertEquals(1,roverID2);
    }

    @Test
    public void testMoveRoverWithOneInstruction() {
        //plateau size 10, 10
        MissionControl mcontrol =  MissionControl.createMissionControlInstance(10, 10);
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
        MissionControl mcontrol =  MissionControl.createMissionControlInstance(10, 10);
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
        MissionControl mcontrol =  MissionControl.createMissionControlInstance(5,5);
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

    @Test
    public void testMoveRoverInstructionOutOfBounds() {
        //plateau size 10, 10
        MissionControl mcontrol =  MissionControl.createMissionControlInstance(10, 10);
        int roverID1 = mcontrol.createRover(9, 9, Direction.N);
        MoveOutcome result = mcontrol.moveRover(roverID1, "MM");

        assertFalse(result.isSuccess());
        assertEquals(9,result.getEndPosition().getX());
        assertEquals(10,result.getEndPosition().getY());
        assertEquals(Direction.N,result.getEndPosition().getOrientation());
        assertEquals(9,result.getFailedPosition().getX());
        assertEquals(11,result.getFailedPosition().getY());
        assertEquals("Position is outside of Plateau bounds.", result.getStatusMessage());

    }

    @Test
    public void testMoveRoverCollision() {
        //plateau size 10, 10
        MissionControl mcontrol =  MissionControl.createMissionControlInstance(10, 10);
        int roverID1 = mcontrol.createRover(5, 5, Direction.N);
        MoveOutcome result1 = mcontrol.moveRover(roverID1, "MM");

        int roverID2 = mcontrol.createRover(5, 5, Direction.N);
        MoveOutcome result2 = mcontrol.moveRover(roverID2, "MM");

        assertFalse(result2.isSuccess());
        assertEquals(5,result2.getEndPosition().getX());
        assertEquals(6,result2.getEndPosition().getY());
        assertEquals(Direction.N,result2.getEndPosition().getOrientation());
        assertEquals(5,result2.getFailedPosition().getX());
        assertEquals(7,result2.getFailedPosition().getY());
        assertEquals("Position is obstructed by another Rover.", result2.getStatusMessage());

    }
}
