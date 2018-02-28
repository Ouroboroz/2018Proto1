package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AngleClawUp extends Command {

    public AngleClawUp() {
       
    	requires(Robot.claw);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	if(Robot.claw.currentLocation == 1)
    		cancel();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.claw.goUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.claw.winchLimit.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.claw.stopWinch();
    	Robot.claw.currentLocation = 1;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.claw.stopWinch();

    }
}
