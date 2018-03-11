package org.usfirst.frc.team2554.robot.commands.auto;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.commands.Claw.ShootCube;
import org.usfirst.frc.team2554.robot.commands.Claw.WinchUpScale;
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
        addSequential(new DriveStraight(26, Robot.driveTrain.MinSpeed, true, side*0));
        addSequential(new RotateToAngle(-90*side));
        addSequential(new DriveStraight(0.33, Robot.driveTrain.MinSpeed,true, -90*side));
        addSequential(new MoveElevator(2));
        addSequential(new WinchUpScale());
        addSequential(new ShootCube(3, -1));
        

    }
}
