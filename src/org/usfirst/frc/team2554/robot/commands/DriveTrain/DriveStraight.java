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
	PIDController StraightPID = getPIDController();
	public DriveStraight(double distance, double speed, boolean stop, double heading) {
		super(0.1,0,.225,0.02); //p = 0.08
		this.speed = speed;
		if(stop)
			this.distance = distance-0.9166;
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
		System.out.println("Error" + (distance - Robot.driveTrain.getDistance()));
	Robot.driveTrain.myDrive.arcadeDrive(speed, rotation);
	}

	@Override
	protected boolean isFinished() {
	
		return (Robot.driveTrain.getDistance() >= distance);
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