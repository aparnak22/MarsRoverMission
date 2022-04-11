package marsrovermission;

import marsrovermission.util.Direction;
import marsrovermission.util.SpinDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNavigationHelperSpin {
    NavigationHelper navigationHelper = NavigationHelper.getInstance();

    @Test
    public void testSpinRightFromNorth(){
        Position pos = new Position(1,1, Direction.N);
        Direction result = navigationHelper.calculateNewSpinDirection(pos,SpinDirection.R);

        assertEquals(Direction.E, result);
    }

    @Test
    public void testSpinRightFromEast(){
        Position pos = new Position(1,1,Direction.E);
        Direction result = navigationHelper.calculateNewSpinDirection(pos,SpinDirection.R);

        assertEquals(Direction.S, result);
    }

    @Test
    public void testSpinRightFromSouth(){
        Position pos = new Position(1,1,Direction.S);
        Direction result = navigationHelper.calculateNewSpinDirection(pos,SpinDirection.R);

        assertEquals(Direction.W, result);
    }

    @Test
    public void testSpinRightFromWest(){
        Position pos = new Position(1,1,Direction.W);
        Direction result = navigationHelper.calculateNewSpinDirection(pos,SpinDirection.R);

        assertEquals(Direction.N, result);
    }

    @Test
    public void testSpinLeftFromWest(){
        Position pos = new Position(1,1,Direction.W);
        Direction result = navigationHelper.calculateNewSpinDirection(pos,SpinDirection.L);

        assertEquals(Direction.S, result);
    }

    @Test
    public void testSpinLeftFromNorth(){
        Position pos = new Position(1,1,Direction.N);

        Direction result = navigationHelper.calculateNewSpinDirection(pos,SpinDirection.L);

        assertEquals(Direction.W, result);
    }
}
