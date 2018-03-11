package org.usfirst.frc.team2554.robot.commands.Claw;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class ShootCube extends TimedCommand {
	double speed;
    public ShootCube(double timeout, double speed) {
        super(timeout);
        this.speed = speed;
        // Use requires() here to declare subsystem dependencies
        requires(Robot.claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.claw.setSpeed(speed);
    	//-0.2
    }

    // Called once after timeout
    protected void end() {
    	Robot.claw.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.claw.stop();
    }
}
