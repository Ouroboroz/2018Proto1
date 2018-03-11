package org.usfirst.frc.team2554.robot.commands.Claw;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class WinchUpScale extends InstantCommand {

    public WinchUpScale() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.claw);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.claw.winchSpeed(0.7);
    	Timer.delay(1.43);
    	Robot.claw.stopWinch();
    }

}
