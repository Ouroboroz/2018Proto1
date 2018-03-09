package org.usfirst.frc.team2554.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2554.robot.commands.Claw.BaseAngle;
import org.usfirst.frc.team2554.robot.commands.Claw.Retrieve;
import org.usfirst.frc.team2554.robot.commands.Claw.ScaleAngle;
import org.usfirst.frc.team2554.robot.commands.Claw.Shooter;
import org.usfirst.frc.team2554.robot.commands.Claw.WinchDown;
import org.usfirst.frc.team2554.robot.commands.Claw.WinchUp;
import org.usfirst.frc.team2554.robot.commands.Elevator.ManualElevator;
import org.usfirst.frc.team2554.robot.commands.Elevator.MoveElevator;
import org.usfirst.frc.team2554.robot.subsystems.Elevator;
import org.usfirst.frc.team2554.robot.triggers.Intake;
import org.usfirst.frc.team2554.robot.triggers.ManualControl;
import org.usfirst.frc.team2554.robot.triggers.Outtake;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	

     //0: HOME
	// 1: SWITCH 
	// 2: SCALE
	// 3: CLIMB
	public Joystick leftStick = new Joystick(0);
	public Joystick rightStick = new Joystick(1);
	public Joystick mechController = new Joystick(2);
	
	//BUTTONS 
	
	
	// Levels
	int buttonHome = 1;
	int buttonSwitch = 2;
	int buttonScale = 4;
	
	

	//Elevator
	int toggleRatchetButton = 3;
	
	
	//Winch
	int winchControlUp =  6;
	int winchControlDown = 5;
	//AXES 
	
	//Claw
	int intakeControl = 2;
	int outtakeControl = 3;

	
	//Elevator
	int elevatorControl = 1;
	
	//Elevator Buttons
	public Button home = new JoystickButton(mechController, buttonHome);
    public Button switche = new JoystickButton(mechController, buttonSwitch);
    public Button scale = new JoystickButton(mechController, buttonScale);
    
   //Climbing
    public Button toggleRatchet = new JoystickButton(mechController, toggleRatchetButton);
    
    
    public Button winchUp = new JoystickButton(mechController, winchControlUp);
    public Button winchDown = new JoystickButton(mechController, winchControlDown);
    
    public Trigger manualControl = new ManualControl(mechController, elevatorControl);
    public Trigger intake = new Intake(mechController, intakeControl);
    public Trigger outtake = new Outtake(mechController, outtakeControl);
   
 
    public double elevatorControl() //manual elevator
 	{
 		return -1*mechController.getRawAxis(elevatorControl);
 	}
    
    public double intakeSpeed() // claw
    {
    	return mechController.getRawAxis(intakeControl);
    }
    
    public double outtakeSpeed() // claw
    {
    	return mechController.getRawAxis(outtakeControl);
    }
 
    public double leftSide() //tank drive
    {
    	return -1*leftStick.getY();
    }
    
    public double rightSide() //tank drive
    {
    	return -1*rightStick.getY();
    }
    

	
    public double verticalSpeed() //arcade drive
    {
    	return -1*leftStick.getY();
    }
    
    public double rotationSpeed() // arcade drive
    {
    	return leftStick.getZ();
    }
	public OI() {
		
		

		home.whenPressed(new MoveElevator(0));
		switche.whenPressed(new MoveElevator(1));
		scale.whenPressed(new MoveElevator(2));
		

		winchUp.whileHeld(new WinchUp());
		winchDown.whileHeld(new WinchDown());	
		
		manualControl.whileActive(new ManualElevator());
		intake.whileActive(new Retrieve());
		outtake.whileActive(new Shooter());
	}

	
	
}
