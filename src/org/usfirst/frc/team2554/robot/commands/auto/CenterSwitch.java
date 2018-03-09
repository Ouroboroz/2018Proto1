package org.usfirst.frc.team2554.robot.commands.auto;

import org.usfirst.frc.team2554.robot.commands.Claw.ShootCube;
import org.usfirst.frc.team2554.robot.commands.Claw.Shooter;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.DistanceDriveFinal;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.RotateToAngle;
import org.usfirst.frc.team2554.robot.commands.Elevator.MoveElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterSwitch extends CommandGroup {

    public CenterSwitch(int side) {
		addParallel(new MoveElevator(1));
    	addSequential(new DistanceDriveFinal(4.75));
		addSequential(new RotateToAngle(90*side));
		addSequential(new DistanceDriveFinal(7.17));
		addSequential(new RotateToAngle(-90*side));
		addSequential(new DistanceDriveFinal(6.84));
		addSequential(new RotateToAngle(-90*side));
		addSequential(new DistanceDriveFinal(2.84));
        addSequential(new ShootCube(3));
    }
}
