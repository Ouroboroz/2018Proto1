package org.usfirst.frc.team2554.robot.subsystems;
import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 *
 */
public class Intake extends Subsystem {

    Victor leftMotor = new Victor(RobotMap.intake[0]);
    Victor rightMotor = new Victor(RobotMap.intake[1]);
    
    PowerDistributionPanel pdp = new PowerDistributionPanel();

    
    SpeedControllerGroup intake = new SpeedControllerGroup(leftMotor, rightMotor);

    public void initDefaultCommand() {
     
    }
    public Intake() {
    		
    }
   
    public void setSpeed(double speed)
    {
    	intake.set(speed);    	
    }
    
    public double getCurrent()
    {
    	return pdp.getCurrent(RobotMap.pdpMotor);
    }
}

