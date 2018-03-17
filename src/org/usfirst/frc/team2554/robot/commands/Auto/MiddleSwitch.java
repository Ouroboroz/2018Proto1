package org.usfirst.frc.team2554.robot.commands.Auto;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.commands.Claw.ShootIntakeCube;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.RotateToAngle;
import org.usfirst.frc.team2554.robot.commands.Elevator.MoveElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddleSwitch extends CommandGroup {

    public MiddleSwitch(int side) {
        if(side==1)
        {
        	addSequential(new DriveStraight(3.5, Robot.driveTrain.MinSpeed, true, 0));
        	addSequential(new RotateToAngle(90));
        	addSequential(new RotateToAngle(0));
        	addParallel(new MoveElevator(1));
        }
        
        
        if(side == -1)
        {
        	addSequential(new DriveStraight(3.5, Robot.driveTrain.MinSpeed, true, 0));
        	addSequential(new RotateToAngle(-90));
        	addSequential(new RotateToAngle(0));
        	addSequential(new MoveElevator(1));
        }
    }
}
