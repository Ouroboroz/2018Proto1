package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	
    	double speed = Robot.oi.elevatorControl()*0.888;
    	System.out.println(speed);
    	System.out.println(Robot.elevator.currentLocation() >= 0);
    	System.out.println( !Robot.oi.limitSwitchBypass());
    	if(false)//Robot.elevator.updateStatus() >= 0 && !Robot.oi.limitSwitchBypass())
    	{
    		Robot.elevator.stall();
    	}
    	
    	else
    	{
        	//Robot.elevator.move(speed + -1*Robot.elevator.holdingPower);
    		SmartDashboard.putNumber("Input Value", speed);
    		SmartDashboard.putNumber("Holding Power", -1*Robot.elevator.holdingPower);
        	SmartDashboard.putNumber("Actual Speed", (speed + -1*Robot.elevator.holdingPower)*-1);
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
