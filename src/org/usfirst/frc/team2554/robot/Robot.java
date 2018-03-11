
package org.usfirst.frc.team2554.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
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
import org.usfirst.frc.team2554.robot.commands.DriveTrain.RotateToAngle;
import org.usfirst.frc.team2554.robot.commands.auto.AutoTest;
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
	String message = "";

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
		Robot.driveTrain.resetDriveTrain();
		int robotLocation = LocationChooser.getSelected();
		if(message.length()<2)
		{		
			do {

				message = DriverStation.getInstance().getGameSpecificMessage();
			}
			while(message.length() < 2);
		} 
		
		
		if(robotLocation == 100)
			autonomousCommand = new SideLineCross();
		
		else if (robotLocation == 200)
			autonomousCommand = new CenterLineCross(1);
			
		
		else
		{
			int switchLocation = (message.charAt(0) == 'L') ? -1 : 1;
			int scaleLocation =  (message.charAt(1) == 'L') ? -1 : 1;
			
			if(robotLocation == 0) // Robot in the middle 
			{
				autonomousCommand = new CenterSwitch(switchLocation);
				System.out.println("Center Auto");
			}
			
			
			else
			{
				if(robotLocation == switchLocation){
					autonomousCommand = new SameSideSwitch(robotLocation);
				}
				else if(robotLocation == scaleLocation)
					autonomousCommand = new SameSideScale(robotLocation);
				else{
					//autonomousCommand = new OppositeSideSwitch(robotLocation);
					autonomousCommand = new SideLineCross();
				}
					 
			}
		}
		
		//autonomousCommand = new OppositeSideSwitch(-1) ;
		
		//autonomousCommand = new SameSideScale(1);
	//	autonomousCommand = new SameSideSwitch(1);
		//autonomousCommand = new SameSideScale(1);
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
		//elevator.log();
		//driveTrain.log();
		//claw.log();
	}




}
