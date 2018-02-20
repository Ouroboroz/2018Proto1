package org.usfirst.frc.team2554.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int[] driveTrain = {0,1,2,3};
	public static int[] claw = {4, 5};
	public static int winch = 6;

	public static int[] elevator = {7,8};
	public static int[] spark = {9};
	
	
	public static int[] limitSwitches = {5,6,7,8};
	public static int[] encoderLeft = {0,1};
	public static int[] encoderRight = {2,3};
	public static int[] encoderWinch = {4, 9};

}
