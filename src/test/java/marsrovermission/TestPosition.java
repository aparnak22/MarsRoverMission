package marsrovermission;

import marsrovermission.util.Direction;
import marsrovermission.util.SpinDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPosition {

    @Test
    public void testSpinRightFromNorth(){
        Position pos = new Position(1,1, Direction.N);
        pos.spin(SpinDirection.R);

        assertEquals(Direction.E, pos.getOrientation());
    }

    @Test
    public void testSpinRightFromEast(){
        Position pos = new Position(1,1,Direction.E);
        pos.spin(SpinDirection.R);

        assertEquals(Direction.S, pos.getOrientation());
    }

    @Test
    public void testSpinRightFromSouth(){
        Position pos = new Position(1,1,Direction.S);
        pos.spin(SpinDirection.R);

        assertEquals(Direction.W, pos.getOrientation());
    }

    @Test
    public void testSpinRightFromWest(){
        Position pos = new Position(1,1,Direction.W);
        pos.spin(SpinDirection.R);

        assertEquals(Direction.N, pos.getOrientation());
    }

    @Test
    public void testSpinLeftFromWest(){
        Position pos = new Position(1,1,Direction.W);
        pos.spin(SpinDirection.L);

        assertEquals(Direction.S, pos.getOrientation());
    }

    @Test
    public void testSpinLeftFromNorth(){
        Position pos = new Position(1,1,Direction.N);
        pos.spin(SpinDirection.L);

        assertEquals(Direction.W, pos.getOrientation());
    }
}
