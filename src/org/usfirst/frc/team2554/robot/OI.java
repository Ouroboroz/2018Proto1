package org.usfirst.frc.team2554.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2554.robot.commands.ManualElevator;
import org.usfirst.frc.team2554.robot.commands.MoveElevator;
import org.usfirst.frc.team2554.robot.commands.Retrieve;
import org.usfirst.frc.team2554.robot.commands.Shooter;
import org.usfirst.frc.team2554.robot.commands.ToggleRatchet;
import org.usfirst.frc.team2554.robot.triggers.ManualControl;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	

     //0: HOME
	// 1: SWITCH j 
	// 2: PORTAL 
	// 3: SCALE
	// 4: CLIMB
	public Joystick leftStick = new Joystick(0);
	public Joystick rightStick = new Joystick(1);
	public Joystick mechController = new Joystick(2);
	
	//Buttons 
	
	
	// Levels
	int buttonHome = 1;
	int buttonPortal = 2;
	int buttonSwitch = 3;
	int buttonScale = 4;
	int buttonClimb = 8 ;
	
	//Claw
	int intakeButton = 5;
	int outakeButton = 6;
	
	//Elevator
	int manualControlStop = 10;
	
	//End Game
	int toggleRatchetButton = 7;
	
	
	//Axeses
	int clawSpeedControl = 1;
	int elevatorControl = 5;

	
	
	public Button home = new JoystickButton(mechController, buttonHome);
	public Button portal = new JoystickButton(mechController, buttonPortal);
    public Button switche = new JoystickButton(mechController, buttonSwitch);
    public Button scale = new JoystickButton(mechController, buttonScale);
    public Button climb = new JoystickButton(mechController, buttonClimb);
    public Button intake = new JoystickButton(mechController, intakeButton);
    public  Button outake = new JoystickButton(mechController, outakeButton);
    public Button toggleRatchet = new JoystickButton(mechController, toggleRatchetButton);

    public Trigger manualControl = new ManualControl();
    
    
    public boolean limitSwitchBypass()
    {
    	return mechController.getRawButton(manualControlStop);
    }
 
    public double elevatorControl() 
 	{
 		return -1*mechController.getRawAxis(elevatorControl);
 	}
    
 
    public double leftSide()
    {
    	return -1*leftStick.getY();
    }
    
    public double rightSide()
    {
    	return -1*rightStick.getY();
    }
    
    public double clawSpeed()
    {
    	return -1*mechController.getRawAxis(clawSpeedControl);
    }
	
	public OI() {
		
		
		

		home.whenPressed(new MoveElevator(0));
		switche.whenPressed(new MoveElevator(1));
		portal.whenPressed(new MoveElevator(2));
		scale.whenPressed(new MoveElevator(3));
		climb.whenPressed(new MoveElevator(4));
		intake.whileHeld(new Retrieve());
		outake.whileHeld(new Shooter());
		manualControl.whileActive(new ManualElevator());
		toggleRatchet.whenPressed(new ToggleRatchet());
	}

	
	
}
