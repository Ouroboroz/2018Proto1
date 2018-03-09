
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
import org.usfirst.frc.team2554.robot.commands.auto.CenterLineCross;
import org.usfirst.frc.team2554.robot.commands.auto.CenterSwitch;
import org.usfirst.frc.team2554.robot.commands.auto.OppositeSideSwitch;
import org.usfirst.frc.team2554.robot.commands.auto.SameSideScale;
import org.usfirst.frc.team2554.robot.commands.auto.SameSideSwitch;
import org.usfirst.frc.team2554.robot.commands.auto.SideLineCross;
import org.usfirst.frc.team2554.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	
	Command autonomousCommand; 
	SendableChooser<Integer> LocationChooser = new SendableChooser<>();
	String message;

	public static  DriveTrain driveTrain;
	public static  Elevator elevator;
	public static  Claw claw;
	public static OI oi ;
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {

		driveTrain = new DriveTrain();
		elevator = new Elevator();
		claw = new Claw();
		oi = new OI();
		LocationChooser.addObject("Left", -1);
		LocationChooser.addObject("Middle", 0);
		LocationChooser.addObject("Right", 1);
		LocationChooser.addObject("Side Cross", 100);
		LocationChooser.addObject("Middle Cross", 200);
		SmartDashboard.putData("Location", LocationChooser);
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
		do
		{
			 message = DriverStation.getInstance().getGameSpecificMessage();
		}
		while(message.length() < 2);
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
		Robot.driveTrain.resetDriveTrain();


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
		driveTrain.log();
		claw.log();
	}




}
