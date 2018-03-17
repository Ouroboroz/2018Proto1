package org.usfirst.frc.team2554.robot.commands.Auto;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.commands.Claw.ShootIntakeCube;
import org.usfirst.frc.team2554.robot.commands.Claw.Shooter;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.RotateToAngle;
import org.usfirst.frc.team2554.robot.commands.Elevator.MoveElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SameSideSwitch extends CommandGroup {

    public SameSideSwitch(int side) {
        addSequential(new DriveStraight(12.5, Robot.driveTrain.MinSpeed, true, side*0));
		addSequential(new RotateToAngle(-90 * side));
		addSequential(new MoveElevator(1));
		addSequential(new DriveStraight(3.34, Robot.driveTrain.MinSpeed, true, -90*side));
        addSequential(new ShootIntakeCube(3,0.2));
    }
}
