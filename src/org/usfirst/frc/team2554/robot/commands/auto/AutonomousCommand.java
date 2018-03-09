package org.usfirst.frc.team2554.robot.commands.auto;

import org.usfirst.frc.team2554.robot.commands.Claw.Shooter;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.DistanceDriveFinal;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.RotateToAngle;
import org.usfirst.frc.team2554.robot.commands.Elevator.MoveElevator;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {
	int ELEVATOR_INITIAL_POSITION = 1; // Scoring Position

	public AutonomousCommand() {

		final String fmsData = DriverStation.getInstance().getGameSpecificMessage(); // FMS on which side the scale is
																						// one
		int switchClosePosition = 0;
		int scalePosition = 0;
		int switchFarPosition = 0;

		if (fmsData.charAt(0) == 'L') {
			switchClosePosition = -1; // Left
		} else {
			switchClosePosition = 1; // Right
		}

		if (fmsData.charAt(1) == 'L') {
			scalePosition = -1; // Left
		} else {
			scalePosition = 1; // Right
		}

		if (fmsData.charAt(2) == 'L') {
			switchFarPosition = -1; // Left
		} else {
			switchFarPosition = 1; // Right
		}

		int positionRobotDashboard = 0; // to read position
		int scorePositionDashboard = 0; // choose which side to score

		switch (positionRobotDashboard) {
		case 0:// Start on the right side of the field
		{
			if (scorePositionDashboard == 0) // Scoring the switch
			{
				if (switchClosePosition == -1) // Scoring the left side of the switch closest to the starting position
				{
					addSequential(new DistanceDriveFinal(19.17));
					addParallel(new MoveElevator(1));
					addSequential(new RotateToAngle(90*switchClosePosition));
					addSequential(new DistanceDriveFinal(21));
					addSequential(new RotateToAngle(-90*switchClosePosition));
					addSequential(new DistanceDriveFinal(5.084));
					addSequential(new RotateToAngle(-90*switchClosePosition));
					addSequential(new DistanceDriveFinal(2.84));
					addSequential(new Shooter());

				}

				if (switchClosePosition == 1) // Scoring the right side of the switch closest to the starting position
				{
					addSequential(new DistanceDriveFinal(12.5));
					addParallel(new MoveElevator(1));
					addSequential(new RotateToAngle(90 * switchClosePosition));
					addSequential(new DistanceDriveFinal(2.84));
					addSequential(new Shooter());

				}
			}

			if (scorePositionDashboard == 1) // Scoring the scale
			{
				if (scalePosition == -1) // Scoring the left side of the scale
				{

				}

				if (scalePosition == 1) // Scoring the right side of the scale
				{

				}
			}
			break;
		}
		case 1:// Start in the middle of the field
		{
			if (scorePositionDashboard == -1) // Scoring the switch on the left side
			{
				addSequential(new DistanceDriveFinal(4.75));
				addParallel(new MoveElevator(1));
				addSequential(new RotateToAngle(90*switchClosePosition));
				addSequential(new DistanceDriveFinal(7.17));
				addSequential(new RotateToAngle(-90*switchClosePosition));
				addSequential(new DistanceDriveFinal(6.84));
				addSequential(new RotateToAngle(-90*switchClosePosition));
				addSequential(new DistanceDriveFinal(2.84));
				addSequential(new Shooter());
			}

			if (scorePositionDashboard == 1) // Scoring the swicth on the right side 
			{
				addSequential(new DistanceDriveFinal(4.75));
				addParallel(new MoveElevator(1));
				addSequential(new RotateToAngle(90*switchClosePosition));
				addSequential(new DistanceDriveFinal(7.17));
				addSequential(new RotateToAngle(-90*switchClosePosition));
				addSequential(new DistanceDriveFinal(6.84));
				addSequential(new RotateToAngle(-90*switchClosePosition));
				addSequential(new DistanceDriveFinal(2.84));
				addSequential(new Shooter());	

			}
			break;
		}
		case 2:// Start on the left side of the field
		{

			if (scorePositionDashboard == 0) // Scoring the switch
			{
				if (switchClosePosition == -1) // Scoring the left side of the switch closest to the starting position
				{
					addSequential(new DistanceDriveFinal(12.5));
					addParallel(new MoveElevator(1));
					addSequential(new RotateToAngle(90*switchClosePosition));
					addSequential(new DistanceDriveFinal(2.84));
					addSequential(new Shooter());

				}

				if (switchClosePosition == 1) // Scoring the right side of the switch closest to the starting position
				{
					addSequential(new DistanceDriveFinal(19.17));
					addParallel(new MoveElevator(1));
					addSequential(new RotateToAngle(90*switchClosePosition));
					addSequential(new DistanceDriveFinal(21));
					addSequential(new RotateToAngle(-90*switchClosePosition));
					addSequential(new DistanceDriveFinal(5.084));
					addSequential(new RotateToAngle(-90*switchClosePosition));
					addSequential(new DistanceDriveFinal(2.84));
					addSequential(new Shooter());

				}
			}

			if (scorePositionDashboard == 1) // Scoring the scale
			{
				if (scalePosition == -1) // Scoring the left side of the scale
				{

				}

				if (scalePosition == 1) // Scoring the right side of the scale
				{

				}
			}

		}
			break;
		}

		// Code to put cube one scale and end operations

	}
}
