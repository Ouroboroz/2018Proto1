package org.usfirst.frc.team2554.robot.commands.auto;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.commands.Claw.ShootCube;
import org.usfirst.frc.team2554.robot.commands.Claw.Shooter;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.RotateToAngle;
import org.usfirst.frc.team2554.robot.commands.Elevator.MoveElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterSwitch extends CommandGroup {

    public CenterSwitch(int side) {
    	
    	if(side == 1)
    	{	
    	addSequential(new DriveStraight(3.75, Robot.driveTrain.MinSpeed, true, 0*side));
		addSequential(new RotateToAngle(90*side));
		addSequential(new DriveStraight(7.67, Robot.driveTrain.MinSpeed, true, 90*side));
		addSequential(new RotateToAngle(0*side));
		addSequential(new DriveStraight(8.84, Robot.driveTrain.MinSpeed, true, 0*side));
		addSequential(new RotateToAngle(-90*side));
		addSequential(new MoveElevator(1));
		addSequential(new DriveStraight(2.5, Robot.driveTrain.MinSpeed, true, -90*side));
        addSequential(new ShootCube(3, -0.2));
    	}
    	
    	if(side ==-1)
    	{
    		addSequential(new DriveStraight(3.75, Robot.driveTrain.MinSpeed, true, 0*side));
    		addSequential(new RotateToAngle(90*side));
    		addSequential(new DriveStraight(9.67, Robot.driveTrain.MinSpeed, true, 90*side));
    		addSequential(new RotateToAngle(0*side));
    		addSequential(new DriveStraight(8.84, Robot.driveTrain.MinSpeed, true, 0*side));
    		addSequential(new RotateToAngle(-90*side));
    		addSequential(new MoveElevator(1));
    		addSequential(new DriveStraight(2.5, Robot.driveTrain.MinSpeed, true, -90*side));
            addSequential(new ShootCube(3, -0.2));
    		
    	}
    }
}
