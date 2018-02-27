package org.usfirst.frc.team2554.robot.subsystems;
import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 *
 */
public class Claw extends Subsystem {

    Victor leftMotor = new Victor(RobotMap.claw[0]);
    Victor rightMotor = new Victor(RobotMap.claw[1]);
    
    Victor winchMotor = new Victor(RobotMap.winch);
    public Encoder winchTracker = new Encoder(RobotMap.encoderWinch[0], RobotMap.encoderWinch[1]);
    public DigitalInput winchLimit = new DigitalInput(RobotMap.winchLimit);
    
    public double topToBottomDist;
    
    
    


    public void initDefaultCommand() {
    	
    	
     
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
    
    public double distance()
    {
    	return winchTracker.getDistance();
    }
    
    public void reset()
    {
    	winchTracker.reset();
    }
 
    public void log()
    {
    	SmartDashboard.putNumber("Claw Speed", leftMotor.get());
    }
    
    public void goDown()
    {
    	winchTracker.reset();
    	winchMotor.set(-0.5);
    }
    
    public void goUp()
    {
    	winchMotor.set(0.5);
    }
    
    public void stopWinch()
    {
    	winchMotor.set(0);
    }
}

