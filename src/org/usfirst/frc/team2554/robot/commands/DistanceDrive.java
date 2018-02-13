package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DistanceDrive extends Command {

    double angle;
    double Kp = 0.03;
    double distance = 0;

    

    public DistanceDrive(double dist) {
    	
        requires(Robot.driveTrain);
        distance = dist;
        
    }

    protected void initialize() {
        Robot.driveTrain.resetGyro();
        Robot.driveTrain.resetDistance();
    }

    protected void execute() {
        angle = Robot.driveTrain.getGyroAngle();
        Robot.driveTrain.myDrive.arcadeDrive(0.5, angle * Kp);
    }

    protected boolean isFinished() {
    
    	if(Robot.driveTrain.getDistance() >= distance)
    		return true;
    	
        return false;
    }
    
    
    protected void end() {
    	Robot.driveTrain.myDrive.arcadeDrive(0,0);
    	Robot.driveTrain.resetDistance();
        Robot.driveTrain.resetGyro();
    }

    protected void interrupted() {
    	Robot.driveTrain.myDrive.arcadeDrive(0,0);
    	Robot.driveTrain.resetDistance();
        Robot.driveTrain.resetGyro();

    }
    

}