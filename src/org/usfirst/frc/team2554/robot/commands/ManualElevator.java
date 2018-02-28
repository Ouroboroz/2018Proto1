package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ManualElevator extends Command {

	public ManualElevator() {

		requires(Robot.elevator);
	}

	protected void initialize() {
	}

	protected void execute() {

		double speed = Robot.oi.elevatorControl()*0.888;
		Robot.elevator.move((speed + -1*Robot.elevator.holdingPower));
		
		int position = Robot.elevator.currentLocation();
		
		
		if(position >= 0)
			Robot.elevator.currentLocation = position;



	}


	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.elevator.stall();
	}

	protected void interrupted() {
		Robot.elevator.stall();
	}
}
