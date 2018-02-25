
package org.usfirst.frc.team2554.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2554.robot.commands.*;
import org.usfirst.frc.team2554.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	//Test Comment

	
	Command autonomousCommand; 

	public static  DriveTrain driveTrain = new DriveTrain();
	public static  Elevator elevator = new Elevator();
	public static  Claw claw = new Claw();
	public static  Ratchet ratchet = new Ratchet();
	public static OI oi = new OI();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {

		

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {

		if (autonomousCommand != null)
			autonomousCommand.start();	

	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log();


	}

	@Override
	public void teleopInit() {


		if (autonomousCommand != null)
			autonomousCommand.cancel();


	}


	@Override
	public void teleopPeriodic() {

		Scheduler.getInstance().run();
		log();
	}


	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}

	public void log()
	{
		elevator.log();
		ratchet.log();
		driveTrain.log();
		claw.log();
	}




}
