package org.usfirst.frc.team2554.robot.commands.Relics;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class FollowTrajectory extends Command {

	private final double MAX_VELOCITY = 0;
	private final double MAX_ACCELERATION = 0;
	private final double MAX_JERK = 0;
	private final double WHEELBASE_WIDTH = 0;
	private final int TICKS_PER_REV = 128;
	private final double WHEEL_DIAMETER = 6;
	private final Trajectory.Config config;
	private final Trajectory trajectory;
	private final TankModifier modifier;
	private final EncoderFollower left;
	private final EncoderFollower right;

	
	double kp = 0;
	double ki = 0;
	double kd = 0;
	double kv = 1/MAX_VELOCITY;
	double ka = 0;
	private FollowTrajectory(Waypoint[] points) {

		config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, MAX_VELOCITY, MAX_ACCELERATION, MAX_JERK);
		trajectory = Pathfinder.generate(points, config);
		modifier = new TankModifier(trajectory).modify(WHEELBASE_WIDTH);
		left = new EncoderFollower(modifier.getLeftTrajectory());
		right = new EncoderFollower(modifier.getLeftTrajectory());

	}

	protected void initialize() {
		Robot.driveTrain.resetDriveTrain(); //resets encoders and gyro. 
		left.configureEncoder(0, TICKS_PER_REV,WHEEL_DIAMETER);
		left.configurePIDVA(kp, ki, kd, kv, ka);
		
		right.configureEncoder(0, TICKS_PER_REV,WHEEL_DIAMETER);
		right.configurePIDVA(kp, ki, kd, kv, ka);
	}

	protected void execute() {
		
		double leftOutput = left.calculate(Robot.driveTrain.encoderLeft.get());
		double rightOutput = right.calculate(Robot.driveTrain.encoderRight.get());
		
		double currentAngle = Robot.driveTrain.getGyroAngle();
		double desiredAngle = Pathfinder.r2d(left.getHeading());
		
		double angleDifference = Pathfinder.boundHalfDegrees(desiredAngle - currentAngle);
		double turn = 0.8*(-1.0/80.0) * angleDifference;
		
		Robot.driveTrain.myDrive.tankDrive(leftOutput + turn, leftOutput - turn);
		
		
	}

	protected boolean isFinished() {
		return left.isFinished() && right.isFinished();
	}

	protected void end() {
		Robot.driveTrain.stop();
	}

	
	protected void interrupted() {
		Robot.driveTrain.stop();

	}
}
