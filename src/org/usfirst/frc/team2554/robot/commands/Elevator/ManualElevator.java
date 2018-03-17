package org.usfirst.frc.team2554.robot.commands.Elevator;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ManualElevator extends Command {

	boolean slowSpeed;
	double multiplier = 1;
	public ManualElevator() {

		requires(Robot.elevator);
	}

	protected void initialize() {
	}

	protected void execute() {

		if(Robot.elevator.getLimit(1) && Robot.elevator.elevatorMotor1.get() > 0)
			slowSpeed = true;
		
		if(Robot.elevator.getLimit(1) && Robot.elevator.elevatorMotor1.get() < 0)
			slowSpeed = false;
		
		if(slowSpeed && Robot.oi.elevatorControl() > 0)
			multiplier = 0.5;
		
			
		else
			multiplier = 1;
		
		
		
		
		double speed = Robot.oi.elevatorControl()*0.9*multiplier;
		
	//	if(speed<0)
	//	{
	//		speed *= 0.5;
	//	}
		Robot.elevator.move((speed + Robot.elevator.holdingPower));
		
		
		
		
		
		
		int position = Robot.elevator.getCurrentLocation();
		
		
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
