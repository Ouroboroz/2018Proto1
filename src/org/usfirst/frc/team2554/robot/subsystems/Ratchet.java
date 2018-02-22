package org.usfirst.frc.team2554.robot.subsystems;

import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Ratchet extends Subsystem {

	Spark ratchet = new Spark(RobotMap.spark[0]);
	public boolean ratchetStatus = false;
	public double ratchetSpeed = 0.2;
	
	

    public void initDefaultCommand() {
    }
    
    public void setRatchet(boolean rat)
	{
		
		 if(rat)
		{
			ratchet.set(ratchetSpeed);
			ratchetStatus = true;
		}

		else 
		{
			ratchetStatus = false;
			ratchet.set(0);
		}
		
	}
    
    public void log()
    {
    	SmartDashboard.putBoolean("Ratchet Status" , ratchetStatus);
    }
}

