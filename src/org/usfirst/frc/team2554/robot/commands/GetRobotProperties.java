package org.usfirst.frc.team2554.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc.team2554.robot.Robot;
import java.time.Instant;
import java.time.Duration;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class GetRobotProperties extends TimedCommand {
	Instant start;
	List<Double> rateList = new ArrayList<Double>();
	List<Double> acclList = new ArrayList<Double>();
	List<Double> jerkList = new ArrayList<Double>();
	
    public GetRobotProperties() {
        super(15);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	start = Instant.now();
    	Robot.driveTrain.myDrive.tankDrive(1.0, 1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
    	Instant current = Instant.now();
    	long currentTime = Duration.between(start , current).toMillis();
    	if(currentTime == 100){
    		start = current;
    		Double rate = (Robot.driveTrain.encoderLeft.getRate() + Robot.driveTrain.encoderRight.getRate())/2;
    		Double accl = rate/0.1;
    		Double jerk = accl/0.1;
    		
    		rateList.add(rate);
    		acclList.add(accl);
    		jerkList.add(jerk);
    		
    		SmartDashboard.putNumberArray("Speed", (Double[])rateList.toArray());
    		SmartDashboard.putNumberArray("Accleeration", (Double[])acclList.toArray());
    		SmartDashboard.putNumberArray("Jerk", (Double[])jerkList.toArray());
    	}
    }

    // Called once after timeout
    protected void end(){
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
