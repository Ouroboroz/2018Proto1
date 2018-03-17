package org.usfirst.frc.team2554.robot.subsystems;
import org.usfirst.frc.team2554.robot.RobotMap;
import org.usfirst.frc.team2554.robot.commands.Claw.WinchHolding;
import org.usfirst.frc.team2554.robot.commands.Elevator.HoldElevator;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 *
 */
public class Claw extends Subsystem {

	Victor leftMotor = new Victor(RobotMap.claw[0]);
	Victor rightMotor = new Victor(RobotMap.claw[1]);

	Victor winchMotor = new Victor(RobotMap.winch);
	//public DigitalInput winchLimit = new DigitalInput(RobotMap.winchLimit);


	public double currentLocation = 0;

	

	public void initDefaultCommand() {

		setDefaultCommand(new WinchHolding());


	}
	public Claw() {
		
	}

	public void setSpeed(double speed)
	{
		leftMotor.set(speed); 
		rightMotor.set(speed);
	}

	public void stop()
	{
		leftMotor.set(0);
		rightMotor.set(0);
	}
	public void log()
	{
		SmartDashboard.putNumber("Claw Speed", leftMotor.get());
		//SmartDashboard.putBoolean("Claw Limit", winchLimit.get());
	}

	public void winchSpeed(double speed)
	{
		winchMotor.set(speed);
	}
	
	public void stopWinch()
	{
		winchMotor.set(0);
	}
	
}

