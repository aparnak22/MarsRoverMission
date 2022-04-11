package marsrovermission;

import marsrovermission.model.Direction;
import marsrovermission.model.Plateau;
import marsrovermission.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlateau {

    @Test
    public void testPositionIsInGrid(){
        Plateau pl = new Plateau(10,10);
        Position p = new Position(2,2, Direction.N);
        assertTrue(pl.isPositionInside(p));
    }

    @Test
    public void tesXPositionIsOutOfTheGrid(){
        Plateau pl = new Plateau(10,10);
        Position p = new Position(11,2, Direction.N);
        assertFalse(pl.isPositionInside(p));
    }

    @Test
    public void testYPositionIsOutOfTheGrid(){
        Plateau pl = new Plateau(10,10);
        Position p = new Position(3,11, Direction.N);
        assertFalse(pl.isPositionInside(p));
    }
}
