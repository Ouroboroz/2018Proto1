package org.usfirst.frc.team2554.robot.triggers;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.buttons.Trigger;


/**
 *
 */
public class RatchetBackup extends Trigger {
	double time;
    public boolean get() {
    	time = DriverStation.getInstance().getMatchTime();
        return (time<10);
    }
}
