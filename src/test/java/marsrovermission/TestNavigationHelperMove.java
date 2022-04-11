package marsrovermission;

import marsrovermission.model.Direction;
import marsrovermission.model.Position;
import marsrovermission.service.NavigationHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNavigationHelperMove {

    @Test
    public void testMoveForward(){

            Position startP  = new Position(1,2,Direction.N);

            Position newP = NavigationHelper.getInstance().calculateNewPosition(startP, 1);

            assertEquals(2,newP.getX());
            assertEquals(2,newP.getY());
   }

    @Test
    public void testMoveDown(){

        Position startP  = new Position(1,2,Direction.S);

        Position newP = NavigationHelper.getInstance().calculateNewPosition(startP, 1);

        assertEquals(0,newP.getX());
        assertEquals(2,newP.getY());
    }

    @Test
    public void testMoveRight(){

        Position startP  = new Position(1,2,Direction.E);

        Position newP = NavigationHelper.getInstance().calculateNewPosition(startP, 1);

        assertEquals(1,newP.getX());
        assertEquals(3,newP.getY());
    }

    @Test
    public void testMoveLeft(){

        Position startP  = new Position(1,2,Direction.W);

        Position newP = NavigationHelper.getInstance().calculateNewPosition(startP, 1);

        assertEquals(1,newP.getX());
        assertEquals(1,newP.getY());
    }


}
