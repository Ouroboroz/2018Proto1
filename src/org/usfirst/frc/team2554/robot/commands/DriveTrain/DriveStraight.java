package org.usfirst.frc.team2554.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2554.robot.Robot;

/**
 *
 */
public class DriveStraight extends PIDCommand {
	
	double speed;
	double distance;
	boolean endStop;
	double jank = 0.9166/2;
	Timer timer = new Timer();
	boolean timeOut = false;
	PIDController StraightPID = getPIDController();
	public DriveStraight(double distance, double speed, boolean stop, double heading) {
		super(0.1,0,.225,0.02); //p = 0.08
		this.speed = speed;
		if(stop)
			this.distance = distance-jank;
		else
			this.distance = distance;
		getPIDController().setInputRange(-180,180);
		getPIDController().setOutputRange(-1, 1);
		getPIDController().setSetpoint(heading);
		getPIDController().setContinuous(true);
		requires(Robot.driveTrain);
		endStop = stop;
	}

	protected void initialize() {
		Robot.driveTrain.resetDriveTrain();
	}

	@Override
	protected double returnPIDInput() {
		
		return Robot.driveTrain.getGyroAngle();
		}

	@Override
	protected void usePIDOutput(double rotation) {
		Robot.driveTrain.myDrive.arcadeDrive(speed, rotation);
	}

	@Override
	protected boolean isFinished() {
	
		if(Robot.driveTrain.getDistance() > 0.75*distance)
		{	
			timer.start();
			timeOut = true;
		}
		
		else
			timeOut = false;
			
		return (Robot.driveTrain.getDistance() >= distance || (timeOut && timer.get()>5 ));
	}
	

	protected void end(){
		
		if(endStop)
			Robot.driveTrain.stop();
		
	}
	
	protected void interrupted()
	{
		Robot.driveTrain.stop();
	}
}