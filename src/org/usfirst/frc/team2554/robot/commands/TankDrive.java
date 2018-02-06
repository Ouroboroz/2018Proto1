package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends Command {
	double leftSide;
	double rightSide;
	double sensitivity = 0.6;
	final public double DEADZONE = 0.15;
    public TankDrive() {

    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
  
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftSide = Robot.oi.leftStick.getY();
    	rightSide = Robot.oi.rightStick.getY();
    	if(isDeadzone(leftSide, DEADZONE))
    		leftSide = 0;
    	
    	if(isDeadzone(rightSide, DEADZONE))
    		rightSide = 0;
    	
    	Robot.driveTrain.teleopDrive(leftSide*sensitivity, rightSide*sensitivity);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    public static boolean isDeadzone(double value, double deadzone)
    {
    	if(value<deadzone)
    	{
    		return true;
    	}
    	
    	return false;
    }
}
