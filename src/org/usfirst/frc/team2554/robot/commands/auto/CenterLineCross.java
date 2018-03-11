package org.usfirst.frc.team2554.robot.commands.auto;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.commands.Claw.Shooter;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.RotateToAngle;
import org.usfirst.frc.team2554.robot.commands.Elevator.MoveElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */

//Check if this actually works. 
public class CenterLineCross extends CommandGroup {

    public CenterLineCross(int side) {
    	addSequential(new DriveStraight(4.75, Robot.driveTrain.MinSpeed, true, 0*side));
		addSequential(new RotateToAngle(90*side));
		addSequential(new DriveStraight(7.17, Robot.driveTrain.MinSpeed, true, 90*side));
		addSequential(new RotateToAngle(0*side));
		addSequential(new DriveStraight(6.84, Robot.driveTrain.MinSpeed, true, 0*side));
    }
}
