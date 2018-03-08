package org.usfirst.frc.team2554.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2554.robot.Robot;

/**
 *
 */
public class DriveStraight extends PIDCommand {
	
	double speed;
	double distance;
	PIDController StraightPID = getPIDController();
	public DriveStraight(double distance, double speed) {
		super(.07,.05,.3);
		this.speed = speed;
		this.distance = distance;
		getPIDController().setInputRange(-180,180);
		getPIDController().setOutputRange(-1, 1);
		getPIDController().setPercentTolerance(0.5);
		getPIDController().setSetpoint(0);
		getPIDController().setContinuous(true);
		requires(Robot.driveTrain);
	}

	protected void initialize() {
		Robot.driveTrain.resetDriveTrain();
	}

	@Override
	protected double returnPIDInput() {
		
		return Robot.driveTrain.getGyroAngle();
		}

	@Override
	protected void usePIDOutput(double rotation) {
	Robot.driveTrain.myDrive.arcadeDrive(speed, rotation);
	}

	@Override
	protected boolean isFinished() {
	
		return (Robot.driveTrain.getDistance() > distance);
	}
	

	protected void end(){
		
	}
	
	protected void interrupted()
	{
		Robot.driveTrain.stop();
	}
}