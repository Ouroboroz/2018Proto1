package org.usfirst.frc.team2554.robot.subsystems;

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

	// Put methods for controlling this subsystem
	// here. Call these from Commands.



	// 0: HOME
	// 1: SWITCH
	// 2: PORTAL 
	// 3: SCALE
	// 4: CLIMB

	Victor elevatorMotor1 = new Victor(RobotMap.elevator[0]);
	Victor elevatorMotor2 = new Victor(RobotMap.elevator[1]); //Elevator Motor 2

	DigitalInput[] limit = { new DigitalInput(RobotMap.limitSwitches[0]), new DigitalInput(RobotMap.limitSwitches[1]),new DigitalInput(RobotMap.limitSwitches[2]),new DigitalInput(RobotMap.limitSwitches[3]),new DigitalInput(RobotMap.limitSwitches[4])};
	
	Spark ratchet = new Spark(RobotMap.spark[0]);
	public boolean ratchetStatus;
	
	
	public void initDefaultCommand() {
		setDefaultCommand(new HoldElevator());
	}

	//

	public void setRatchet(boolean rat)
	{
		
		 if(rat)
		{
			ratchet.set(RobotMap.up * RobotMap.rSpeed);
			ratchetStatus = true;
		}

		else 
		{
			ratchetStatus = false;
			ratchet.set(0);
		}
		
	}

	public void move(double speed)
	{
		if(!((speed>0) && getLimit(4)) && !((speed<0) && getLimit(0)) && !((ratchetStatus) && (speed<0)))
		{
		SmartDashboard.putNumber("Motor Speed", speed);
		elevatorMotor1.set(speed);
		elevatorMotor2.set(speed);
		}
		
		else
			stop();
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

	public int updateStatus()	
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
	
	public boolean atLocation(int goal, int currentLocation)
	{
		if(getLimit(goal) && getLimit(currentLocation))
		{
			return true;
		}
		
		return false;
	}
	
	public void log()
	{
		SmartDashboard.putNumber("Limit Switch", updateStatus());
		SmartDashboard.putBoolean("Limit 0", limit[0].get());
		SmartDashboard.putBoolean("Limit 1", limit[1].get());
		SmartDashboard.putBoolean("Limit 2", limit[2].get());
		SmartDashboard.putBoolean("Limit 3", limit[3].get());
		SmartDashboard.putBoolean("Limit 4", limit[4].get());

	}

	
}

