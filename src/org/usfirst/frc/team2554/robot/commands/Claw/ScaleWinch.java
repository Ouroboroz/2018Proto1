package org.usfirst.frc.team2554.robot.commands.Claw;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class ScaleWinch extends TimedCommand {

	double speed = 0.7;
    public ScaleWinch(double timeout) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        requires(Robot.claw);
    }
    
    public ScaleWinch(double timeout, double speed) {
        super(timeout);
        this.speed = speed;
        requires(Robot.claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.claw.winchSpeed(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Command Working");
    	Robot.claw.winchSpeed(speed);
    }

    // Called once after timeout
    protected void end() {
    	Robot.claw.stopWinch();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.claw.stopWinch();
    }
}
