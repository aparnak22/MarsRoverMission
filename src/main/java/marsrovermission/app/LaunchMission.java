package marsrovermission.app;

import marsrovermission.model.Direction;
import marsrovermission.model.Position;
import marsrovermission.model.Rover;

import java.util.Scanner;

public class LaunchMission {

    public static void main(String... args){

        System.out.println("Welcome to Mission Mars ! This is your chance to move a rover on the surface of Mars. ");
        System.out.println("You have the conn ! ");

        //Get Plateau dimensions
        Scanner scanner = new Scanner(System.in);

        int[] plateauSize = null;

        while (plateauSize == null) {
            String plateauSizeString = getPlateauSize(scanner);
            if (MissionControlInputHelper.validatePlateauInput(plateauSizeString)) {
                plateauSize = MissionControlInputHelper.getPlateuSizeAsInt(plateauSizeString);
            }
            else {
                System.out.println("Invalid plateau size. Please try again.");
            }
        }

        MissionControl missionControl = new MissionControl(plateauSize[0],plateauSize[1]);

        int[] roverIds = new int[2];

        for (int i = 0; i < 2; i++) {

            Position roverStartPos = null;
            while (roverStartPos == null) {
                //Get Rover1 coordinates
                String roverString = getRoverStartPosition(i + 1, scanner);
                if (MissionControlInputHelper.validateRoverCoordinates(roverString)) {
                    roverStartPos = MissionControlInputHelper.getRoverCoordinatesAsPositon(roverString);
                } else {
                    System.out.println("Invalid rover start coordinates. Please try again.");
                }
            }
            roverIds[i] = missionControl.createRover(roverStartPos.getX(),
                                            roverStartPos.getX(),
                                                roverStartPos.getOrientation());
            //Get Rover instructions
            String roverInstructions = getRoverInstructionsFor( i+1, scanner);

            MoveOutcome result = missionControl.moveRover(roverIds[i], roverInstructions);

                if ( result.isSuccess())
                 System.out.println(result.getEndPosition().toString());
                else {
                    System.out.println(result.getStatusMessage() + " " + result.getFailedPosition());
                    System.out.println("Rover has stopped at " + result.getEndPosition().toString());
                }


        }
          //Ask to continue
          boolean repeatMove = true;
          while (repeatMove) {
              System.out.println("Continue moving the rovers (Y/N) ? ");
              String continueMove = scanner.nextLine();
              if ( continueMove.trim().equalsIgnoreCase("Y")){

                  System.out.println("Which rover would you like to move (1/2) ? ");

                  String roverNumStr = scanner.nextLine();

                  int roverNumInt = Integer.parseInt(roverNumStr.trim());
                  //Get Rover instructions
                  String roverInstructions = getRoverInstructionsFor( roverNumInt, scanner);
                  MoveOutcome result = missionControl.moveRover(roverIds[roverNumInt-1], roverInstructions);

                  if ( result.isSuccess())
                      System.out.println(result.getEndPosition().toString());
                  else {
                      System.out.println(result.getStatusMessage() + " " + result.getFailedPosition());
                      System.out.println("Rover has stopped at " + result.getEndPosition().toString());
                  }
              }
              else repeatMove = false;

          }
        // Enter rover 1 instructions
        //Enter rover 2 instructions

    }

    private static int[] getCoordinates(String input){
        String[] inputs = input.split(" ");
        int[] intArr = new int[2];
        intArr[0] = Integer.parseInt(inputs[0]);
        intArr[1] = Integer.parseInt(inputs[1]);
        return intArr;
    }
    
    public void displayMsg(String message) {
        System.out.println(message);
    }

    
    public static String getPlateauSize(Scanner scanner) {
        System.out.println("Plateau size as the maximum x and y co-ordinates in the format  X Y . ");
        return scanner.nextLine();
    }

    
    public static String getRoverStartPosition(int no, Scanner scanner) {
        System.out.println("Rover " + no + "'s start position as X and Y coordinates and a orientation " +
                "in the format X Y N/E/S/W . ");
        return scanner.nextLine();
    }

    
    public static String getRoverInstructionsFor(int no,Scanner scanner) {
        System.out.println("Instructions for rover no " + no );
        return scanner.nextLine();
    }


}
