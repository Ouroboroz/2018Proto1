package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualElevator extends Command {

    public ManualElevator() {

    requires(Robot.elevator);
    }

    protected void initialize() {
    }

    protected void execute() {
    	
    	
    	if(Robot.elevator.updateStatus() >= 0 && !Robot.oi.limitSwitchBypass())
    	{
    		Robot.elevator.stall();
    	}
    	
    	else
    	{
        	Robot.elevator.move(Robot.oi.elevatorControl());
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.elevator.stall();
    }

    protected void interrupted() {
    	Robot.elevator.stall();
    }
}
