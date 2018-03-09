package org.usfirst.frc.team2554.robot.commands.auto;

import org.usfirst.frc.team2554.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoTest extends CommandGroup {

    public AutoTest() {
    //	addSequential(new DriveStraight(1, 0.5, false));
    	//addSequential(new DriveStraight(1, 0.6, true));

    	//addSequential(new DriveStraight(5, 0.5,true));
    	
    	//addSequential(new DriveStraight(5, 0.8, false));
    	//addSequential(new DriveStraight(2, 0.5, true));
    	
    //	addSequential(new DriveStraight(9, 0.5, true));
    //	addSequential(new DriveStraight(6, 0.8, true));
   // 	addSequential(new DriveStraight(3, 0.5, true));
    	
    	addSequential(new DriveStraight(100/12, 0.8, false, 0) );
    	addSequential(new DriveStraight(54/12, 0.5, true, 0));
    	addSequential(new WaitCommand(0.5));
    	addSequential(new RotateToAngle(-90));
    	addSequential(new DriveStraight(100/12, 0.6, false,-90));
    	addSequential(new DriveStraight(58/12, 0.5, true, -90));

//Go 153
    //Turn -90
    //    addSequential(new WaitCommand(3));
    //	addSequential(new RotateToAngle(-90));

    }
}
