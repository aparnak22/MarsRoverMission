package marsrovermission.app;

import marsrovermission.model.Direction;
import marsrovermission.model.Position;

public class MissionControlInputHelper {

    public static boolean validatePlateauInput(String plateuSize){
        return plateuSize.matches("([0-9].*)( )([0-9].*)");
    }

    public static int[] getPlateuSizeAsInt(String plateuSize){
        String[] inputs = plateuSize.split(" ");
        int[] intArr = new int[2];
        intArr[0] = Integer.valueOf(inputs[0]).intValue();
        intArr[1] = Integer.valueOf(inputs[1]).intValue();
        return intArr;
    }

    public static boolean validateRoverCoordinates(String roverPostion){
        return roverPostion.matches("([0-9].*)( )([0-9].*)( )[NESW]");
    }

    public static Position getRoverCoordinatesAsPositon(String roverStartString){
        String[] startCoordinatesStr = roverStartString.split(" ");
        Position pos = new Position(
        Integer.valueOf(startCoordinatesStr[0].trim()).intValue(),
                Integer.valueOf(startCoordinatesStr[1].trim()).intValue(),
                Direction.valueOf(startCoordinatesStr[2].trim().toUpperCase()));
        return pos;
    }

    public static void main(String args[]){
        System.out.println("8 8 " + validatePlateauInput("8 8"));
        System.out.println("8  " + validatePlateauInput("8 "));
        System.out.println("8 8 0" + validatePlateauInput("8 8 0"));
        System.out.println("82 822 " + validatePlateauInput("82 822  "));
        System.out.println("-1 8 0" + validatePlateauInput("-1 8 0 "));


        System.out.println("1 8 N " + validateRoverCoordinates("1 8 N"));
        System.out.println("1 8 " + validateRoverCoordinates("1 8 "));
        System.out.println("1 8 Q " + validateRoverCoordinates("1 8 Q"));


    }
}
