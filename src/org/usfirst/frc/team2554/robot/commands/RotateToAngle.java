package org.usfirst.frc.team2554.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2554.robot.Robot;

/**
 *
 */
public class RotateToAngle extends PIDCommand {
	
	int counter = 0;
	int angle;
	int timeCheck = 0;
	boolean timerStatus = false;
	Timer timer = new Timer();
	double TimeOnTarget = 0.5;
	public RotateToAngle(int angle1) {
		
		super(0,0,0);
		Robot.driveTrain.resetDriveTrain();
		double P = SmartDashboard.getNumber("P", 0.08);
		double I = SmartDashboard.getNumber("I", 0);
		double D = SmartDashboard.getNumber("D", .2);
		getPIDController().setPID(P, I, D);
		angle = angle1;
		getPIDController().setInputRange(-180,180);
		getPIDController().setOutputRange(-0.75, 0.75);
		getPIDController().setAbsoluteTolerance(3);
		getPIDController().setSetpoint(angle);
		getPIDController().setContinuous(true);
		requires(Robot.driveTrain);
	}

	protected void initialize() {
	}

	@Override
	protected double returnPIDInput() {
		//System.out.println(angle-Robot.driveTrain.getGyroAngle());
		System.out.println("Angle: " + Robot.driveTrain.getGyroAngle());
		return Robot.driveTrain.getGyroAngle();
	}

	@Override
	protected void usePIDOutput(double speed) {
		System.out.println("Speed: " + speed);
		System.out.println("hah");
		Robot.driveTrain.myDrive.arcadeDrive(0,1*speed );
		System.out.println("Error: " + getPIDController().getError());
	}

	@Override
	protected boolean isFinished() {
	
		if ( getPIDController().onTarget() && timeCheck<1)
		{
			timeCheck = 1;
			timer.start();
			timerStatus = true;
		}
		
		if (!getPIDController().onTarget()&&timeCheck>0)
		{
			timer.stop();
			timer.reset();
			timerStatus = false;
			timeCheck =0;
		}
		return timerStatus && timer.get ()> TimeOnTarget;
	}
	

	protected void end(){
		System.out.println("Angle Reached. Command Terminated");
		getPIDController().disable();
		Robot.driveTrain.myDrive.arcadeDrive(0, 0);
	}
}