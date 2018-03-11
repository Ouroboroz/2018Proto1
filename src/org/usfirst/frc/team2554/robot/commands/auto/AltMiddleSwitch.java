package org.usfirst.frc.team2554.robot.commands.auto;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.commands.Claw.ShootCube;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.RotateToAngle;
import org.usfirst.frc.team2554.robot.commands.Elevator.MoveElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AltMiddleSwitch extends CommandGroup {

    public AltMiddleSwitch(int side) {
        if(side==1)
        {
        	addSequential(new DriveStraight(5, Robot.driveTrain.MinSpeed, true, 0));
        	addSequential(new RotateToAngle(90));
        	addSequential(new DriveStraight (5.2, Robot.driveTrain.MinSpeed, true, 90));
        	addSequential(new RotateToAngle(0));
        	addParallel(new MoveElevator(1));
        	addSequential(new DriveStraight(3.65, Robot.driveTrain.MinSpeed, true, 0));
        	addSequential(new ShootCube(3,-0.2));
        }
        
        
        if(side == -1)
        {
        	addSequential(new DriveStraight(5, Robot.driveTrain.MinSpeed, true, 0));
        	addSequential(new RotateToAngle(-90));
        	addSequential(new DriveStraight (5.5, Robot.driveTrain.MinSpeed, true, -90));
        	addSequential(new RotateToAngle(0));
        	addParallel(new MoveElevator(1));
        	addSequential(new DriveStraight(3.65, Robot.driveTrain.MinSpeed, true, 0));
        	addSequential(new ShootCube(3,-0.2));
        }
    }
}
