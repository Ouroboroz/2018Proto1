package org.usfirst.frc.team2554.robot.commands.auto;

import org.usfirst.frc.team2554.robot.commands.Claw.ShootCube;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.DistanceDriveFinal;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.RotateToAngle;
import org.usfirst.frc.team2554.robot.commands.Elevator.MoveElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class SameSideScale extends CommandGroup {

    public SameSideScale(int side) {  
        addParallel(new MoveElevator(3));
        addSequential(new DistanceDriveFinal(25.5));
        addSequential(new RotateToAngle(-90*side));
        addSequential(new DistanceDriveFinal(2));
        addSequential(new ShootCube(3));
    }
}
