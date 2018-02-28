package org.usfirst.frc.team2554.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {
	int ELEVATOR_INITIAL_POSITION = 1; //Scoring Position

    public AutonomousCommand() {
    		
    		final String scaleSide = DriverStation.getInstance().getGameSpecificMessage(); //FMS on which side the scale is one
		int direction = 0;
    		
		while(scaleSide.length() == 3)
		{
    		if (scaleSide.charAt(0) == 'L')
    		{
    			direction = -1; //Left 
    		}
    		else
    		{
    			direction = 1; //Right 
    		}
		
    		int positionRobotDashboard = 0;//to read position
    		switch (positionRobotDashboard) 
    		{
    			case 0://Robot starts on the right
    			{	
    				addSequential(new MoveElevator(1));			
            		if(direction == 1) //If the scale is on the right
            		{
            			addSequential(new DistanceDriveFinal(150));
            			addSequential(new RotateToAngle(-90));
            			addSequential(new DistanceDriveFinal(41));
            		}
            		else //If the scale is on the left
            		{
            			addSequential(new DistanceDriveFinal(209));
            			addSequential(new RotateToAngle(-90));
            			addSequential(new DistanceDriveFinal(264));
            			addSequential(new RotateToAngle(-90));
            			addSequential(new DistanceDriveFinal(61));
            			addSequential(new RotateToAngle(-90));
            			addSequential(new DistanceDriveFinal(41));
            		}
    				break;
    			}
    			case 1://Middle
    			{
    				addSequential(new MoveElevator(1));
            		addSequential(new DistanceDriveFinal(60));
            		addSequential(new RotateToAngle(90*direction));
            		addSequential(new DistanceDriveFinal(132));
            		addSequential(new RotateToAngle(-90*direction));
            		addSequential(new DistanceDriveFinal(69));
            		addSequential(new RotateToAngle(-90*direction));
            		addSequential(new DistanceDriveFinal(41));
    				break;
    			}
    			case 2://Left
    			{
    				addSequential(new MoveElevator(1));			
            		if(direction == 1) //If the scale is on the right
            		{
            			addSequential(new DistanceDriveFinal(209));
            			addSequential(new RotateToAngle(90));
            			addSequential(new DistanceDriveFinal(264));
            			addSequential(new RotateToAngle(90));
            			addSequential(new DistanceDriveFinal(61));
            			addSequential(new RotateToAngle(90));
            			addSequential(new DistanceDriveFinal(41));
            		}
            		else //If the scale is on the left
            		{
            			addSequential(new DistanceDriveFinal(150));
            			addSequential(new RotateToAngle(90));
            			addSequential(new DistanceDriveFinal(41));
            		}
    				break;
    			}
    		}
		}
    		
    		//Code to put cube one scale and end operations
    		

    		
    		
    
    }
}
