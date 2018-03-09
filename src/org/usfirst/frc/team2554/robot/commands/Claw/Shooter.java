package org.usfirst.frc.team2554.robot.commands.Claw;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shooter extends Command {

    public Shooter() {

    	
    	requires(Robot.claw);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = -1*Robot.oi.outtakeSpeed();
    	double range = speed*0.8;
    	Robot.claw.setSpeed(-0.2 + range);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.claw.setSpeed(0.0);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.claw.setSpeed(0.0);

    }
}
