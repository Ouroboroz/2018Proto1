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
import org.usfirst.frc.team2554.robot.triggers.Intake;
import org.usfirst.frc.team2554.robot.triggers.ManualControl;
import org.usfirst.frc.team2554.robot.triggers.Outtake;
import org.usfirst.frc.team2554.robot.triggers.RatchetBackup;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	

     //0: HOME
	// 1: SWITCH j 
	// 2: SCALE
	// 3: CLIMB
	public Joystick leftStick = new Joystick(0);
	public Joystick rightStick = new Joystick(1);
	public Joystick mechController = new Joystick(2);
	
	//BUTTONS !!!!!!
	
	
	// Levels
	int buttonHome = 1;
	int buttonSwitch = 2;
	int buttonScale = 4;
	int buttonClimb = 3;
	
	

	//Elevator
	int manualControlStop = 10;
	int toggleRatchetButton = 7;
	
	
	//AXES !!!!!!!!!!!!
	
	//Claw
	int intakeControl = 999;
	int outtakeControl = 999;

	
	//Elevator
	int elevatorControl = 5;
	
	
	public Button home = new JoystickButton(mechController, buttonHome);
    public Button switche = new JoystickButton(mechController, buttonSwitch);
    public Button scale = new JoystickButton(mechController, buttonScale);
    public Button climb = new JoystickButton(mechController, buttonClimb);
    
   
    public Button toggleRatchet = new JoystickButton(mechController, toggleRatchetButton);
    
    public Trigger manualControl = new ManualControl(mechController, elevatorControl);
    public Trigger intake = new Intake(mechController, intakeControl);
    public Trigger outtake = new Outtake(mechController, outtakeControl);
    public Trigger ratchetFailsafe = new RatchetBackup();
    
    public boolean limitSwitchBypass()  // manual elevator              
    {
    	return mechController.getRawButton(manualControlStop);
    }
 
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
		climb.whenPressed(new MoveElevator(3));
		
		toggleRatchet.whenPressed(new ToggleRatchet(!Robot.ratchet.ratchetStatus));

		manualControl.whileActive(new ManualElevator());
		intake.whileActive(new Retrieve());
		outtake.whileActive(new Shooter());
		ratchetFailsafe.whenActive(new ToggleRatchet(true) );
	}

	
	
}
