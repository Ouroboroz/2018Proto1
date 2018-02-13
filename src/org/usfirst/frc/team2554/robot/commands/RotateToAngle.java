package org.usfirst.frc.team2554.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2554.robot.Robot;

/**
 *
 */
public class RotateToAngle extends PIDCommand {
	
	int counter = 0;
	
	public RotateToAngle(int angle) {
		super(0,0,0);
		double P = SmartDashboard.getNumber("P", 0);
		double I = SmartDashboard.getNumber("I", 0);
		double D = SmartDashboard.getNumber("D", 0);
		getPIDController().setPID(P, I, D);
		getPIDController().setInputRange(-180,180);
		getPIDController().setOutputRange(-0.5, 0.5);
		getPIDController().setAbsoluteTolerance(0.005);
		getPIDController().setSetpoint(angle);
		getPIDController().setContinuous(true);
		requires(Robot.driveTrain);
	}

	protected void initialize() {

	}

	@Override
	protected double returnPIDInput() {
		double angle = Robot.driveTrain.getGyroAngle();
		System.out.println(angle);
		return angle;
	}

	@Override
	protected void usePIDOutput(double speed) {
		Robot.driveTrain.myDrive.arcadeDrive(0,-1*speed );
	}

	@Override
	protected boolean isFinished() {
		if(getPIDController().onTarget())
			counter++;
		
		else
			counter--;
			
			
		return counter>2;
	}
	

	protected void end(){
		System.out.println("Angle Reached");
		getPIDController().disable();
	}
}