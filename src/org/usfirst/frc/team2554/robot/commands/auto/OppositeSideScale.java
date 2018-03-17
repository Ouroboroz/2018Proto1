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
public class OppositeSideScale extends CommandGroup {

    public OppositeSideScale(int side) {
    	addParallel(new MoveElevator(3));
    	addSequential(new RotateToAngle(-90*side));
    	addSequential(new DriveStraight(21, Robot.driveTrain.MinSpeed, true, -90*side));
    	addSequential(new RotateToAngle(0*side));
    	addSequential(new DriveStraight(8, Robot.driveTrain.MinSpeed, true, 0*side));
    	addSequential(new RotateToAngle(90*side));
    	addSequential(new DriveStraight(2, Robot.driveTrain.MinSpeed, true, 90*side));
        addSequential(new ShootIntakeCube(3, -1));


    }
}
