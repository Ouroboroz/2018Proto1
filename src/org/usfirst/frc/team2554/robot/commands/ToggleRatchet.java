package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleRatchet extends Command {

    public ToggleRatchet() {
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.setRatchet(true);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	
    	Robot.elevator.move(Robot.oi.elevatorStick.getRawAxis(1));
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.elevator.setRatchet(false);
    	

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
