package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoStraight extends Command {
	double travelDistance = 1200; //in inches
	double rotationLength= 6.0*Math.PI; //in inches
	double distancePerPulse = rotationLength/128;
	Encoder encoderRight = new Encoder(0, 0);
	Encoder encoderLeft = new Encoder(1, 1);

    public GoStraight(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		travelDistance = distance;
    		encoderRight.setDistancePerPulse(distancePerPulse);
    		encoderLeft.setDistancePerPulse(distancePerPulse);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	encoderLeft.reset();
    	encoderRight.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.driveTrain.myDrive.arcadeDrive(1, 1);
		Robot.driveTrain.myDrive.arcadeDrive(0, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(((encoderLeft.getDistance() + encoderRight.getDistance())/2) >= travelDistance) {
        		return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    		encoderLeft.reset();
    		encoderRight.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    		encoderLeft.reset();
		encoderRight.reset();
    }
}
