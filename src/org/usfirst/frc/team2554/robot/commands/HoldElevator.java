package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HoldElevator extends Command {

	private double holdVoltage = -0.15;
    public HoldElevator() {
        
    	requires(Robot.elevator);
    }

    protected void initialize() {
    	
    	Robot.elevator.stall();

    }

    protected void execute() {
    	Robot.elevator.stall();
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
