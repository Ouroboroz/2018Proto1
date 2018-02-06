package org.usfirst.frc.team2554.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.subsystems.DriveTrain;

/**
 *
 */
public class RotateToAngle extends PIDCommand {
	public RotateToAngle(int angle) {
		super(0.019,2,-0.04);
		getPIDController().setInputRange(-180,180);
		getPIDController().setOutputRange(-0.5, 0.5);
		getPIDController().setToleranceBuffer(3);
		getPIDController().setAbsoluteTolerance(0.005);
		getPIDController().setSetpoint(angle);
		getPIDController().setContinuous(true);
		requires(Robot.driveTrain);
	}

	protected void initialize() {
		System.out.println("Lets begin");

	}
	protected void end(){
		System.out.println("Angle Reached");
	}

	@Override
	protected double returnPIDInput() {
		double angle = Robot.driveTrain.getGyroAngle();
		System.out.println(angle);
		return angle;
	}

	@Override
	protected void usePIDOutput(double speed) {
		Robot.driveTrain.myDrive.arcadeDrive(0,0-speed );
	}

	@Override
	protected boolean isFinished() {
		
		return getPIDController().onTarget();
	}
}