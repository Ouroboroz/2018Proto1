package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.RobotMap;
import org.usfirst.frc.team2554.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

     //0: HOME
	// 1: SWITCH
	// 2: PORTAL 
	// 3: SCALE
	// 4: CLIMB
public class MoveElevator extends Command {

	private int goal;
	private int currentLocation;
	private int direction;
	Elevator elevator;
	double[] speed = RobotMap.speeds;
    public MoveElevator(int goal) {
       requires(Robot.elevator);
       elevator = Robot.elevator;
       this.goal = goal;
    }

    protected void initialize() {
    
    }

    protected void execute() {
    	//TODO: Put if condition so that if it doesn't start on a limit switch, code doesn't break!
    	if(elevator.updateStatus()>0)
    	{
    		currentLocation = elevator.updateStatus();
    	}
    	
    	
    	else
    	{
    		currentLocation = 0;
    	}
    	
    	
    	int distance = Math.abs(goal - currentLocation);
    	
    	if(goal>currentLocation)
    		direction = RobotMap.up;
    	    	
    	if(goal<currentLocation)
    		direction = RobotMap.down;
    	
    	
		elevator.move(direction * speed[distance]);
   	
    }

    protected boolean isFinished() {
    	return elevator.atLocation(goal, currentLocation);
    }

    protected void end() {
    	elevator.stop();
    }

    protected void interrupted() {
    }
}
