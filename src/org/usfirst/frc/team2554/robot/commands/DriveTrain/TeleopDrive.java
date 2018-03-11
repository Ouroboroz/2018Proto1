package org.usfirst.frc.team2554.robot.commands.DriveTrain;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleopDrive extends Command {

	double sensitivity = 0.7;
	final public double DEADZONE = 0.15;
    public TeleopDrive() {

    	requires(Robot.driveTrain);
    }

    protected void initialize() {
  
    }

    protected void execute() {

    	
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
