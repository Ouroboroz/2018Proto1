package org.usfirst.frc.team2554.robot.triggers;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class ManualControl extends Trigger {

    public boolean get() {
        return (Robot.oi.elevatorControl() > 0.15 || Robot.oi.elevatorControl()<-0.15);
         
    }
}
