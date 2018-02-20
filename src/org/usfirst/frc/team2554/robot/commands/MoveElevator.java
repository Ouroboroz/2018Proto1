package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

         //0: HOME
	// 1: SWITCH
	// 2: SCALE
	// 3: CLIMB
public class MoveElevator extends Command {

	private int goal;
	private int currentLocation;
	private double speedUp = 0.5;
	private double speedDown = -0.05;
	private double speed=0.11;
    public MoveElevator(int goal) {
        requires(Robot.elevator);
       this.goal = goal;
       
       
       
       
       
       
       
       
       
       

    }

    protected void initialize() {
    	//if(Robot.elevator.updateStatus()<0)
    		//cancel();
    }

    protected void execute() {
    	
    	if(Robot.elevator.updateStatus()>=0)
    	{
    		currentLocation = Robot.elevator.updateStatus();
    	}
    	
    	System.out.println("Move Elevator Running");
    	
    	
    	if(goal>=currentLocation)
    	{
    		speed = speedUp;
    		System.out.println("Speeding Up");
    	}   	
    	if(goal<currentLocation)
    	{	
    		speed = speedDown;
    		System.out.println("Speeding Down");
    	}
    	System.out.println(speed);
		Robot.elevator.move(speed);
   	
    }

    protected boolean isFinished() {
    	return Robot.elevator.atLocation(goal, currentLocation);
    }

    protected void end() {
    	Robot.elevator.stall();
    }

    protected void interrupted() {
    	Robot.elevator.stall();
    }
}
