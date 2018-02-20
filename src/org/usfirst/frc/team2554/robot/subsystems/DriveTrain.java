package org.usfirst.frc.team2554.robot.subsystems;


import org.usfirst.frc.team2554.robot.*;
import org.usfirst.frc.team2554.robot.commands.TeleopDrive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

public class DriveTrain extends Subsystem {


	public DriveTrain()
	{
		double distancePerPulse = (6.0 * Math.PI) / 128;
		gyro.calibrate();
		encoderRight.setDistancePerPulse(distancePerPulse);
		encoderLeft.setDistancePerPulse(distancePerPulse);
		encoderRight.setMaxPeriod(.1);
		encoderLeft.setMaxPeriod(.1);
	}

	Victor frontLeft = new Victor(RobotMap.driveTrain[0]);
	Victor backLeft = new Victor(RobotMap.driveTrain[1]);

	Victor frontRight = new Victor(RobotMap.driveTrain[2]);
	Victor backRight = new Victor(RobotMap.driveTrain[3]);

	public SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);
	public SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);




	public Encoder encoderRight = new Encoder(RobotMap.encoderRight[0], RobotMap.encoderRight[1]);
	public Encoder encoderLeft = new Encoder(RobotMap.encoderLeft[0],RobotMap.encoderLeft[1]);



	public DifferentialDrive myDrive = new DifferentialDrive(left,right);

	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();



	public void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}

	public void tankDrive(double leftVal, double rightVal, double sensitivity, double deadzone)
	{
		if(leftVal<deadzone)
			leftVal = 0;
		
		if (rightVal<deadzone)
			rightVal = 0;
		
		
		myDrive.tankDrive(leftVal*sensitivity, rightVal*sensitivity);
	}
	
	public void arcadeDrive(double forwardSpeed, double rotationSpeed, double sensitivity, double deadzone)
	{
		if(forwardSpeed<deadzone)
			forwardSpeed = 0;
		
		if (rotationSpeed<deadzone)
			rotationSpeed = 0;
		
		myDrive.arcadeDrive(forwardSpeed*sensitivity, rotationSpeed*sensitivity);
	}
	
	public void stop()
	{
		myDrive.stopMotor();
	}



	public double getGyroAngle()
	{
		return gyro.getAngle();
	}


	public double getDistance()
	{
		return ((encoderLeft.getDistance()+encoderRight.getDistance())/2);
	}

	public void resetDriveTrain()
	{
		gyro.reset();
		encoderLeft.reset();
		encoderRight.reset();
	}

	public void log()
	{
		SmartDashboard.putNumber("Angle", getGyroAngle());
		SmartDashboard.putNumber("Distance", getDistance());
		SmartDashboard.putNumber("Left Side Power", left.get());
		SmartDashboard.putNumber("Right Side Power", right.get());
	}
}