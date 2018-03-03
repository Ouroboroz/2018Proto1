package org.usfirst.frc.team2554.robot.commands;

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

				}

				if (switchClosePosition == 1) // Scoring the right side of the switch closest to the starting position
				{

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
			if (scorePositionDashboard == 0) // Scoring the switch
			{
				addSequential(new DistanceDriveFinal(4.9166));
				addParallel(new MoveElevator(1));
				addSequential(new RotateToAngle(90 * switchClosePosition));
				addSequential(new DistanceDriveFinal(132));
				addSequential(new RotateToAngle(-90 * switchClosePosition));
				addSequential(new DistanceDriveFinal(69));
				addSequential(new RotateToAngle(-90 * switchClosePosition));
				addSequential(new DistanceDriveFinal(41));
			}

			if (scorePositionDashboard == 1) // Scoring the scale
			{

			}
			break;
		}
		case 2:// Start on the left side of the field
		{

			if (scorePositionDashboard == 0) // Scoring the switch
			{
				if (switchClosePosition == -1) // Scoring the left side of the switch closest to the starting position
				{

				}

				if (switchClosePosition == 1) // Scoring the right side of the switch closest to the starting position
				{

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
