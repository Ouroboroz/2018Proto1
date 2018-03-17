package org.usfirst.frc.team2554.robot.commands.Auto;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.commands.Claw.ScaleWinch;
import org.usfirst.frc.team2554.robot.commands.Claw.ShootIntakeCube;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.RotateToAngle;
import org.usfirst.frc.team2554.robot.commands.Elevator.MoveElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class SameSideScale extends CommandGroup {

    public SameSideScale(int side) {  
    	addSequential(new DriveStraight(25.5, Robot.driveTrain.MinSpeed, true, side*0));
    	addSequential(new RotateToAngle(-90*side));
    	addSequential(new DriveStraight(1, -0.5, true, -90*side));
    	addSequential(new MoveElevator(2));
    	addSequential(new ShootIntakeCube(3, 0.5));
        


    }
}
