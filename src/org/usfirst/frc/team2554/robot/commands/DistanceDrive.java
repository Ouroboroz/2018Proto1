package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DistanceDrive extends Command {

    double distancePerPulse = (6.0 * 3.1415926535897932384626433832795028841971693993751) / 128; // rotationlength/numberofpulsesperrotation
    double angle;
    double Kp = 0.03;
    double distance = 0;

    

    public DistanceDrive(double dist) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        distance = dist;
        Robot.driveTrain.encoderRight.setDistancePerPulse(distancePerPulse);
        Robot.driveTrain.encoderLeft.setDistancePerPulse(distancePerPulse);
        
        Robot.driveTrain.encoderRight.setMaxPeriod(.1);
        Robot.driveTrain.encoderLeft.setMaxPeriod(.1);
        
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.driveTrain.resetGyro();
        Robot.driveTrain.encoderLeft.reset();
        Robot.driveTrain.encoderRight.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        angle = Robot.driveTrain.getGyroAngle();
        Robot.driveTrain.myDrive.arcadeDrive(0.5, angle * Kp);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (((Robot.driveTrain.encoderLeft.getDistance() + Robot.driveTrain.encoderRight.getDistance()) / 2) >= distance) {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.myDrive.arcadeDrive(0,0);
        Robot.driveTrain.encoderLeft.reset();
        Robot.driveTrain.encoderRight.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.myDrive.arcadeDrive(0,0);
        Robot.driveTrain.encoderLeft.reset();
        Robot.driveTrain.encoderRight.reset();
    }
    
    protected double distanceStatus()
    {
    		return (Robot.driveTrain.encoderLeft.getDistance() + Robot.driveTrain.encoderRight.getDistance()) / 2;
    }
    
    protected double angleStatus()
    {
    		return angle;
    }
    
    protected double updateMotorPowerLeft()
    {
    		return Robot.driveTrain.left.get();
    }
    
    protected double updateMotorPowerRight()
    {
    		return Robot.driveTrain.right.get();
    }
    
    public void log()
	{
		SmartDashboard.putNumber("Encoder Distance", distanceStatus());
		SmartDashboard.putNumber("Angle", angleStatus() );
		SmartDashboard.putNumber("Motor Power Left",updateMotorPowerLeft());
		SmartDashboard.putNumber("Motor Power Right",updateMotorPowerRight());

	}
}