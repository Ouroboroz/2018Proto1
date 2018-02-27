package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AngleClawBase extends Command {

    public AngleClawBase() {
        
    	requires(Robot.claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.claw.winchTracker.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.claw.goDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.claw.winchTracker.get() > Robot.claw.topToBottomDist;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.claw.winchTracker.reset();
    	Robot.claw.stopWinch();


    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.claw.winchTracker.reset();
    	Robot.claw.stopWinch();


    }
}
