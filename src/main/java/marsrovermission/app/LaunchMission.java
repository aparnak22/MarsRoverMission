package marsrovermission.app;

import marsrovermission.model.Position;

import java.util.Scanner;

public class LaunchMission {

    public static final String INVALID_PLATEAU_SIZE = "Invalid plateau size. Please try again.";
    public static final String ROVER_IS_OUTSIDE_THE_PLATEAU = "Rover is outside the plateau. Please try again. ";

    public static void main(String... args){

        System.out.println("Welcome to Mission Mars ! This is your chance to move a rover on the surface of Mars. ");
        System.out.println("You have the con ! ");

        //Get Plateau dimensions
        Scanner scanner = new Scanner(System.in);

        int[] plateauSize = null;

        while (plateauSize == null) {
            String plateauSizeString = getPlateauSize(scanner);
            if (MissionControlInputHelper.validatePlateauInput(plateauSizeString)) {
                plateauSize = MissionControlInputHelper.getPlateuSizeAsInt(plateauSizeString);
            }
            else {
                System.out.println(INVALID_PLATEAU_SIZE);
            }
        }

        MissionControl missionControl =  MissionControl.createMissionControlInstance(plateauSize[0],plateauSize[1]);

        int[] roverIds = new int[2];

        for (int i = 0; i < 2; i++) {

            Position roverStartPos = null;
            int createRoverOut = -1;

            while ( (roverStartPos == null) || createRoverOut == -1 ) {
                //Get Rover1 coordinates
                String roverString = getRoverStartPosition(i + 1, scanner);
                if (MissionControlInputHelper.validateRoverCoordinates(roverString)) {
                    roverStartPos = MissionControlInputHelper.getRoverCoordinatesAsPositon(roverString);

                    createRoverOut = missionControl.createRover(roverStartPos.getX(),
                            roverStartPos.getX(),
                            roverStartPos.getOrientation());
                    if (createRoverOut == -1) {
                        System.out.println(ROVER_IS_OUTSIDE_THE_PLATEAU);
                    }
                    else roverIds[i] = createRoverOut;

                } else {
                    System.out.println("Invalid rover start coordinates. Please try again.");
                }

            }

            //Get Rover instructions
            String roverInstructions = getRoverInstructionsFor( i+1, scanner);

            MoveOutcome result = missionControl.moveRover(roverIds[i], roverInstructions);

                if ( result.isSuccess())
                 System.out.println("Rover " + (i +1 ) + " is at " +  result.getEndPosition().toString());
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
                  MoveOutcome result =  missionControl.moveRover(roverIds[roverNumInt-1], roverInstructions);

                  if ( result.isSuccess())
                      System.out.println("Rover " + roverNumInt  + " at " + result.getEndPosition().toString());
                  else {
                      System.out.println(result.getStatusMessage() + " " + result.getFailedPosition());
                      System.out.println("Rover has stopped at " + result.getEndPosition().toString());
                  }
              }
              else repeatMove = false;

          }


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
