package org.usfirst.frc.team2554.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {
	int ELEVATOR_INITIAL_POSITION = 1; //Scoring Position

    public AutonomousCommand(int direction) {
    		
    		String scaleSide = "";//FMS on which side the scale is one
		//ikik
/*		switch (scaleSide)
		{
			case 0: direction = 1;
				break; 
			
			case 1: direction = -1;
				break;
		}
*/		
    		int positionRobotDashboard = 0;//to read position
    		switch (positionRobotDashboard) 
    		{
    			case 0://Right
    			{	
    				addSequential(new MoveElevator(1));
            		addSequential(new DistanceDrive(60));
            		if(direction == -1)
            		{
            			addSequential(new RotateToAngle(-90));
                		addSequential(new DistanceDrive(264));
                		addSequential(new RotateToAngle(0));
                		addSequential(new DistanceDrive(69));
                		addSequential(new RotateToAngle(90));
                		addSequential(new DistanceDrive(41));
            		}
            		else
            		{
                		addSequential(new DistanceDrive(69));
                		addSequential(new RotateToAngle(-90));
                		addSequential(new DistanceDrive(41));
            		}
    				break;
    			}
    			case 1://Middle
    			{
    				addSequential(new MoveElevator(1));
            		addSequential(new DistanceDrive(60));
            		addSequential(new RotateToAngle(90*direction));
            		addSequential(new DistanceDrive(132));
            		addSequential(new RotateToAngle(-90*direction));
            		addSequential(new DistanceDrive(69));
            		addSequential(new RotateToAngle(-90*direction));
            		addSequential(new DistanceDrive(41));
    				break;
    			}
    			case 2://Left
    			{
    				addSequential(new MoveElevator(1));
            		addSequential(new DistanceDrive(60));
            		if(direction == 1)
            		{
            			addSequential(new RotateToAngle(-90));
                		addSequential(new DistanceDrive(264));
                		addSequential(new RotateToAngle(0));
                		addSequential(new DistanceDrive(69));
                		addSequential(new RotateToAngle(90));
                		addSequential(new DistanceDrive(41));
            		}
            		else
            		{
                		addSequential(new DistanceDrive(69));
                		addSequential(new RotateToAngle(-90));
                		addSequential(new DistanceDrive(41));
            		}
    				break;
    			}
    		}
    		
    		//Code to put cube one scale and end operations
    		

    		
    		
    		
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
