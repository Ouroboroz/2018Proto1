package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */

@SuppressWarnings("static-access")
public class ToggleRatchet extends InstantCommand {

    public ToggleRatchet() {
        
        
    	requires(Robot.elevator);
    }

    // Called once when the command executes
	protected void initialize() {
    	Timer timer = new Timer();
    	Robot.elevator.setRatchet(!Robot.elevator.ratchetStatus);
    	timer.delay(0.5);
    }

}
