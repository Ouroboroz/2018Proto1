package org.usfirst.frc.team2554.robot.commands.auto;

import org.usfirst.frc.team2554.robot.commands.Claw.ShootCube;
import org.usfirst.frc.team2554.robot.commands.Claw.Shooter;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.DistanceDriveFinal;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.RotateToAngle;
import org.usfirst.frc.team2554.robot.commands.Elevator.MoveElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *CHANGGEEEE THIS 
 */
public class OppositeSideSwitch extends CommandGroup {

    public OppositeSideSwitch(int side) {
       
    	addSequential(new DistanceDriveFinal(19.17));
		addParallel(new MoveElevator(1));
		addSequential(new RotateToAngle(-90*side));
		addSequential(new DistanceDriveFinal(21));
		addSequential(new RotateToAngle(90*side));
		addSequential(new DistanceDriveFinal(5.084));
		addSequential(new RotateToAngle(90*side));
		addSequential(new DistanceDriveFinal(2.84));
        addSequential(new ShootCube(3));
    }
}
