package org.usfirst.frc.team2554.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.*;
import edu.wpi.first.wpilibj.DriverStation;
import jaci.pathfinder.modifiers.TankModifier;
import jaci.pathfinder.followers.*;
import org.usfirst.frc.team2554.robot.Robot;

/**
 *
 */
public class MotionProfilingTestCommand extends Command {

    public MotionProfilingTestCommand(int startingPos) {//-1 is left, 0 is center, 1 is right
    		requires(Robot.driveTrain);
    		String gameData;
    		gameData = DriverStation.getInstance().getGameSpecificMessage();
    		int switchSide = 1;
    		if(gameData.charAt(0) == 'L') switchSide = -1;
    		
    		Waypoint[] points = new Waypoint[] {};
    		switch(startingPos) {
    		case -1:
    			break;
    		case 0:
    			switch(switchSide) {
    			case -1:
    				points = new Waypoint[] {
    						new Waypoint(0.0, 13.5, Pathfinder.d2r(0)),
    						new Waypoint(3.0, 13.5, Pathfinder.d2r(0)),
    						new Waypoint(10.0, 24.0, Pathfinder.d2r(0)),
    						new Waypoint(14.0, 20.0, Pathfinder.d2r(270))
    				};
    			case 1:
    				points = new Waypoint[] {
    						new Waypoint(0.0, 13.5, Pathfinder.d2r(0)),
    						new Waypoint(10.0, 3.0, Pathfinder.d2r(0)),
    						new Waypoint(14.0, 7.0, Pathfinder.d2r(90))
    				};
    			}
    			break;
    		case 1:
    			break;
    		default:
    			points = new Waypoint[] {};
    		}

    		Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0);
    		Trajectory trajectory = Pathfinder.generate(points, config);
    		TankModifier modifier = new TankModifier(trajectory);
    		modifier.modify(1.2);
    		
    		Trajectory left  = modifier.getLeftTrajectory();
    		Trajectory right = modifier.getRightTrajectory();
    		
    		EncoderFollower eLeft = new EncoderFollower(left);
    		EncoderFollower eRight = new EncoderFollower(right);
    		
    		//TODO: Initialize EncoderFollowers
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
