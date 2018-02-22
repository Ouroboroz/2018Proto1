package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleopDrive extends Command {

	double sensitivity = 0.8;
	final public double DEADZONE = 0.15;
    public TeleopDrive() {

    	requires(Robot.driveTrain);
    }

    protected void initialize() {
  
    }

    protected void execute() {

    	
    	//Robot.driveTrain.tankDrive(Robot.oi.leftSide(), Robot.oi.rightSide(), sensitivity, DEADZONE);
    	Robot.driveTrain.arcadeDrive(Robot.oi.verticalSpeed(), Robot.oi.rotationSpeed(), sensitivity, DEADZONE);
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.driveTrain.stop();
    }

    protected void interrupted() {
    	Robot.driveTrain.stop();
    }
    
   
}
