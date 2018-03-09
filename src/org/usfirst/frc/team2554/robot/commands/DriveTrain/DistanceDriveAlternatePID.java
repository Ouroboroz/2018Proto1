package org.usfirst.frc.team2554.robot.commands.DriveTrain;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DistanceDriveAlternatePID extends Command {

    double currentAngle;
    double angleError;
    double correctionPower; 
    double straightKp = 0.03;
    double speedKp = 0.35;
    double distance = 0;
    PIDController velocityControl;

   
    public DistanceDriveAlternatePID(double dist) {
    	
        requires(Robot.driveTrain);
        distance = dist;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetDriveTrain();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        currentAngle = Robot.driveTrain.getGyroAngle();
        correctionPower = currentAngle * straightKp;
        
      //  double steeringSpeedRight = 0.5 + correctionPower;
      //  double steeringSpeedLeft =  0.5 - correctionPower;
        	
        double steeringSpeedRight = baseSpeed(Robot.driveTrain.getDistance()) + correctionPower;
        double steeringSpeedLeft = baseSpeed(Robot.driveTrain.getDistance()) - correctionPower;
        System.out.println("Speed Left: " + steeringSpeedLeft);
        Robot.driveTrain.myDrive.tankDrive(steeringSpeedLeft, steeringSpeedRight);
        
        
    }

    protected double baseSpeed(double currentDistance)
    {
    	double error = distance-currentDistance;
    	System.out.println("Distance Away: " + error);
    	double speed = error*speedKp;
    	
    	if(speed>0.8)
    		speed =0.8;
    	
    	if(speed<-0.8)
    		speed = -0.8;
    	
    	System.out.println("Speed: " + speed);
    	return speed;
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        if(Robot.driveTrain.getDistance()>=distance)
        	System.out.println(Robot.driveTrain.getDistance());
        
        
        
      
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.driveTrain.stop();
    }


    protected void interrupted() {
    	Robot.driveTrain.resetDriveTrain();
        Robot.driveTrain.stop();
        
    }
    
   
    
  

   
}