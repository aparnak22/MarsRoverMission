## Mars Rover Mission

### The Brief   

Create a program to move rovers around the surface of Mars!  
The surface of Mars is represented by a Plateau, you can make the assumption that the Plateau is a square/rectangular grid for the purpose of this task.

The Plateau is divided into a grid. 
A Rover’s position is represented by x and y co-ordinates and the letters N, S, W, E to
represent North, South, West, East (the four cardinal compass points) respectively.
 
The program takes as an input the following:
1. The plateau size
2. Position of the first rover
3. Instructions to move the Rover 
 
It then displays the position of the rover following the move and the accepts the 
position of the second rover followed by instructions to move the rover, 
 
## Extension

After the above inputs the user has an option to continue with the program. They can then choose a rover
to move and provide instructions. The program exits when the user does not wish to continue.

## Features

Each rover has a rover ID.
The plateau can be of any Integer size.
The rovers cannot be placed outside of the plateau.
Any attempt to move rover to a position already occupied by another rover or outside the plateau is stopped and 
the current position displayed. The position that is occupied by another rover is also displayed.

## Scope for further enhancements

Allow any number of rovers to be created and managed around the plateau.  











































































At this point the user can provide another move instruction. 

## Limitations

Currently the application allows only 2 rovers to be manipulated. However the core code allows any number
of rovers. The user interface needs to be modifed to support it.

## Design

I started by drawing out a UML of the main classes. This helped move functionality around to allow separation of concerns. 
After I started developing the code and had more clarity there was some more changes to the design as refactoring
moved fuctionality between classes. 

## Testing 

I did follow some TDD (thought not necessarily test first) approach for the classes providing 
each of the different functions.
The rotate rover function has its own test case and so does the move rover function. 
Similarly the Plateau class has its own test case to verify the check for a position outside the plateu works 
as expected. 
Testing each of the functions as I went along meant that by the time the MissionControl class brought all the elements
to together it was already well tested and worked seamlessly.
Debugging was also easier as having the different testcases for the different functions showed exactly where the issue was.
Some of the testcases were renamed following refactoring and moving of fucntionality to different classes.
Again the existing testcases made it easy to verify the refactoring did not break the code. 

## Further Enhancements

1. Enhance the user interface to allow any Integer number of rovers.
2. Introducing a Plateau Interface to allow different shaped and multiple plateaus to allow rovers to work 
simultaneously on diffent regions. 
