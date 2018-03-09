package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WinchStart extends Command {

	
	int topToBottom;  //Distance at the start of the competition to the default position in ticks.
	int initialTicks;
	double speed;
    public WinchStart() {
        
    	requires(Robot.claw);
    	setInterruptible(false);
    }

    protected void initialize() {
    	initialTicks = Robot.claw.distance();
    }

    protected void execute() {
    	Robot.claw.winchSpeed(speed);
    }

    protected boolean isFinished() {
    	
    	int distance = Math.abs((Robot.claw.distance() - initialTicks));
    	
        return distance > topToBottom;
    }

    protected void end() {
    	Robot.claw.stopWinch();

    }

    protected void interrupted() {
    	Robot.claw.stopWinch();
    }
}
