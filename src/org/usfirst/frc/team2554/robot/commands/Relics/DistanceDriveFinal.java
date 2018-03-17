package org.usfirst.frc.team2554.robot.commands.Relics;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2554.robot.Robot;

/**
 *
 */
public class DistanceDriveFinal extends PIDCommand {
	
	
	double distance;
	double currentAngle;
	double straightKp = 0.03;
	double correction;
	
	 double p = 0.8;
	 double i = 0;
	 double d = 0.0;
	
	int timeCheck = 0;
	Timer timer = new Timer();
	boolean timerStatus = false;
	double timeOnTarget = 0.2;
	
	PIDController SpeedPID = getPIDController();
	public DistanceDriveFinal(double dist) {
		super(0,0,0,0.002);
		distance = dist;
		
		
    	SpeedPID.setOutputRange(-0.8, 0.8);
    	SpeedPID.setAbsoluteTolerance(1.0f);
		SpeedPID.setSetpoint(distance);
	
	}
	
	

	protected void initialize() {
		double kP = SmartDashboard.getNumber("kP", p);
		double kI = SmartDashboard.getNumber("kI", i);
		double kD = SmartDashboard.getNumber("kD", d);
		straightKp = SmartDashboard.getNumber("StraightCorrection", straightKp);
		SpeedPID.setPID(kP, kI, kD);
		System.out.println("Command Started");
		System.out.println(SpeedPID.getP());
		Robot.driveTrain.resetDriveTrain();
	}

	@Override
	protected double returnPIDInput() {
		return Robot.driveTrain.getDistance();
	}

	@Override
	protected void usePIDOutput(double speed) {

    	currentAngle = Robot.driveTrain.getGyroAngle();
    	correction = currentAngle*straightKp ;
    	double rightSpeed = speed + correction;
    	double leftSpeed = speed - correction;
    	SmartDashboard.putNumber("Left Speed", leftSpeed);
    	SmartDashboard.putNumber("Right Speed", rightSpeed);
    	SmartDashboard.putNumber("Error", SpeedPID.getError());
        Robot.driveTrain.myDrive.tankDrive(leftSpeed, rightSpeed);
	}

	@Override
	protected boolean isFinished() {
	  return false;
	}
	

	protected void end(){
	SpeedPID.disable();
	Robot.driveTrain.stop();
	}
}