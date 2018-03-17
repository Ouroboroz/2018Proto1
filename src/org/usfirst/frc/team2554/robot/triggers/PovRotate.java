package org.usfirst.frc.team2554.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class PovRotate extends Trigger {

	Joystick stick;
	int angle;
	public PovRotate(Joystick jystick, int angle)
	{
		stick = jystick;
		this.angle = angle;
	}
    public boolean get() {
        return stick.getPOV() == angle;
    }
}
