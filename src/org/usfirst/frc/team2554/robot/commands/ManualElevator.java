package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualElevator extends Command {

    public ManualElevator() {

    requires(Robot.elevator);
    }

    protected void initialize() {
    }

    protected void execute() {
    	
    	double speed = Robot.oi.elevatorControl()*0.4;
    	System.out.println(speed);
    	System.out.println(Robot.elevator.updateStatus() >= 0);
    	System.out.println( !Robot.oi.limitSwitchBypass());
    	if(false)//Robot.elevator.updateStatus() >= 0 && !Robot.oi.limitSwitchBypass())
    	{
    		Robot.elevator.stall();
    	}
    	
    	else
    	{
        	//Robot.elevator.move(speed + -1*Robot.elevator.holdingPower);
        	Robot.elevator.elevatorMotor1.set((speed + -1*Robot.elevator.holdingPower)*-1);
        	Robot.elevator.elevatorMotor2.set((speed + -1*Robot.elevator.holdingPower)*-1);

    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.elevator.stall();
    }

    protected void interrupted() {
    	Robot.elevator.stall();
    }
}
