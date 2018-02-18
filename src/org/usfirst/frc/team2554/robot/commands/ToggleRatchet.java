package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;



public class ToggleRatchet extends InstantCommand {

	
	boolean ratchetStatus;
    public ToggleRatchet(boolean choice) {
        ratchetStatus = choice;
        
    	requires(Robot.ratchet);
    }

    // Called once when the command executes
	protected void initialize() {
    	Robot.ratchet.setRatchet(ratchetStatus);
    	
    }

}
