package org.usfirst.frc.team2554.robot.subsystems;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.RobotMap;
import org.usfirst.frc.team2554.robot.commands.HoldElevator;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {


	



	// 0: HOME
	// 1: SWITCH
	// 2: SCALE
	// 3: CLIMB

	public Victor elevatorMotor1 = new Victor(RobotMap.elevator[0]);
	public Victor elevatorMotor2 = new Victor(RobotMap.elevator[1]);

	DigitalInput[] limit = { new DigitalInput(RobotMap.limitSwitches[0]), new DigitalInput(RobotMap.limitSwitches[1]),new DigitalInput(RobotMap.limitSwitches[2])};
	
	
	public double holdingPower = -0.1111;
	
	public int currentLocation;
	
	
	
	
	
	public Elevator()
	{
		currentLocation = currentLocation();
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new HoldElevator());
	}

	


	public void move(double speed)
	{
		
		if(!(speed>0 && getLimit(2)) && !(speed<0 && getLimit(2)) && !(Robot.ratchet.ratchetStatus && speed<0) )
		{
			elevatorMotor1.set(-speed);
			elevatorMotor2.set(-speed);
		}
		
		else
			stall();
		

	}
	
	public void stall()
	{
		elevatorMotor1.set(holdingPower);
		elevatorMotor2.set(holdingPower);
	}

	public void stop()
	{
		elevatorMotor2.set(0);
		elevatorMotor1.set(0);

	}

	public boolean getLimit(int choice)
	{
		return limit[choice].get();
	}

	public int currentLocation()	
	{
		int currentSpot;
		for(int i = 0; i < limit.length ; i++)
		{
			if(limit[i].get())
			{
				currentSpot = i;
				return currentSpot;
			}

		}

		return -500;
	}
	
	
	
	public void log()
	{
		SmartDashboard.putBoolean("Limit 0", limit[0].get());
		SmartDashboard.putBoolean("Limit 1", limit[1].get());
		SmartDashboard.putBoolean("Limit 2", limit[2].get());
		SmartDashboard.putNumber("Elevator Power", elevatorMotor1.get());

	}

	
}

