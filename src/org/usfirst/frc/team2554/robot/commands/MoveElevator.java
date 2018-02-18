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
	Elevator elevator;
	private double speedUp = 0.2;
	private double speedDown = 0.05;
	private double speed;
    public MoveElevator(int goal) {
       requires(Robot.elevator);
       elevator = Robot.elevator;
       this.goal = goal;
    }

    protected void initialize() {
    	if(elevator.updateStatus()<0)
    		cancel();
    }

    protected void execute() {
    	
    	if(elevator.updateStatus()>=0)
    	{
    		currentLocation = elevator.updateStatus();
    	}
    	
  
    	
    	
    	if(goal>=currentLocation)
    	{
    		speed = speedUp;
    	}   	
    	if(goal<currentLocation)
    	{	
    		speed = speedDown;
    	}
    	
		elevator.move(speed);
   	
    }

    protected boolean isFinished() {
    	return elevator.atLocation(goal, currentLocation);
    }

    protected void end() {
    	elevator.stall();
    }

    protected void interrupted() {
    	elevator.stall();
    }
}
