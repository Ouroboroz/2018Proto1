package org.usfirst.frc.team2554.robot.commands.auto;

import org.usfirst.frc.team2554.robot.commands.DistanceDriveFinal;
import org.usfirst.frc.team2554.robot.commands.MoveElevator;
import org.usfirst.frc.team2554.robot.commands.RotateToAngle;
import org.usfirst.frc.team2554.robot.commands.ShootCube;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class SameSideScale extends CommandGroup {

    public SameSideScale(int side) {  //left is negative. //right is positive 
        addParallel(new MoveElevator(3));
        addSequential(new DistanceDriveFinal(25.5));
        addSequential(new RotateToAngle(-90*side));
        addSequential(new DistanceDriveFinal(2));
        addSequential(new ShootCube(3));
    }
}
