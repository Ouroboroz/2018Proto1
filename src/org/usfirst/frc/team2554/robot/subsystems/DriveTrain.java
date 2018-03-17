package org.usfirst.frc.team2554.robot.subsystems;


import org.usfirst.frc.team2554.robot.*;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.TeleopDrive;

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
		double distancePerPulse = ((6.0 * Math.PI) / 128) / 12; //Feet
		gyro.calibrate();
		encoderRight.setDistancePerPulse(distancePerPulse);
		encoderLeft.setDistancePerPulse(distancePerPulse);
		encoderRight.setMaxPeriod(.1);
		encoderLeft.setMaxPeriod(.1);
		encoderRight.setReverseDirection(false);
		encoderLeft.setReverseDirection(true);
		encoderRight.reset();
		encoderLeft.reset();
	}

	Victor frontLeft = new Victor(RobotMap.driveTrain[0]);
	Victor backLeft = new Victor(RobotMap.driveTrain[1]);

	Victor frontRight = new Victor(RobotMap.driveTrain[2]);
	Victor backRight = new Victor(RobotMap.driveTrain[3]);

	public SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);
	public SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);

	public double MinSpeed = 0.7; 


	public Encoder encoderRight = new Encoder(RobotMap.encoderRight[0], RobotMap.encoderRight[1]);
	public Encoder encoderLeft = new Encoder(RobotMap.encoderLeft[0],RobotMap.encoderLeft[1]);



	public DifferentialDrive myDrive = new DifferentialDrive(left,right);

	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();



	public void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}

	public void tankDrive(double leftVal, double rightVal, double sensitivity, double deadzone)
	{
		
		if(Math.abs(leftVal)< deadzone)
			leftVal = 0;
		
		if(Math.abs(rightVal)< deadzone)
			rightVal = 0;
		
		
		
		myDrive.tankDrive(leftVal*sensitivity, rightVal*sensitivity);
	}
	
	public void arcadeDrive(double forwardSpeed, double rotationSpeed, double sensitivity, double deadzone)
	{
		double sensitivityR = 0.8;
		
		if(Math.abs(forwardSpeed)< deadzone)
			forwardSpeed = 0;
		
		if(Math.abs(rotationSpeed)< deadzone)
			rotationSpeed = 0;
		
		if(Robot.oi.leftStick.getRawButton(1)){
			sensitivityR = 1;
			sensitivity = 1;	
		}
		
		
		if(Robot.oi.leftStick.getRawButton(4))
			myDrive.arcadeDrive(0 , 0.65);
		
		else if(Robot.oi.leftStick.getRawButton(3))
			myDrive.arcadeDrive(0, -0.65);
		
		else if(Robot.oi.leftStick.getRawButton(5))
			myDrive.arcadeDrive(0, -0.9);
		
		else if(Robot.oi.leftStick.getRawButton(6))
			myDrive.arcadeDrive(0, 0.9);
		
		else
		{	
		myDrive.arcadeDrive(forwardSpeed*sensitivity, rotationSpeed*sensitivityR);
		}
		
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
		double currentOutput = (encoderLeft.getDistance()+encoderRight.getDistance())/2;
		return (currentOutput);
	}

	public void resetDriveTrain()
	{
		encoderLeft.reset();
		encoderRight.reset();
	}

	public void log()
	{
		SmartDashboard.putNumber("Angle", getGyroAngle());
		SmartDashboard.putNumber("Distance", getDistance());
		SmartDashboard.putNumber("Left Distance", encoderLeft.getDistance());
		SmartDashboard.putNumber("Right Distance", encoderRight.getDistance());
	//	SmartDashboard.putNumber("Left Speed", encoderLeft.getRate());
	//	SmartDashboard.putNumber("Right Speed", encoderRight.getRate());
	//	SmartDashboard.putNumber("Speed Difference" , encoderLeft.getRate()-encoderRight.getRate());

		
	}
	

}