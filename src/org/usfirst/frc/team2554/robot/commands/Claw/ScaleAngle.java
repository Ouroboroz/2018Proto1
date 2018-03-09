package org.usfirst.frc.team2554.robot.commands.Claw;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ScaleAngle extends Command {
	int baseToScale;  //Distance from base to the scale
	int initialTicks;
	double speed;
    public ScaleAngle() {
    	requires(Robot.claw);
    	setInterruptible(false);
    }

  
    protected void initialize() {
    	
    	if(Robot.claw.currentLocation == 1)
    		cancel();
    	
    	initialTicks = Robot.claw.distance();
    }

    
    protected void execute() {
    	Robot.claw.winchSpeed(speed);
    }

    
    protected boolean isFinished() {
    	int distance = Math.abs((Robot.claw.distance() - initialTicks));

        return distance >= baseToScale;
    }

    protected void end() {
    	Robot.claw.stopWinch();
    	Robot.claw.currentLocation = 1;
    }

    protected void interrupted() {
    	Robot.claw.stopWinch();
    }
}
