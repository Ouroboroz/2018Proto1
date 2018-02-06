package org.usfirst.frc.team2554.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2554.robot.commands.MoveElevator;
import org.usfirst.frc.team2554.robot.commands.ToggleRatchet;


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
	public Joystick mechController = new Joystick(3);
	
	
	int buttonHome = 5;
	int buttonPortal = 3;
	int buttonSwitch = 4;
	int buttonScale = 6;
	int buttonClimb = 1 ;
	int buttonClimbSafety = 9;
	int speedControl = 9;
	int intakeTrigger= 7;
	int outtakeTrigger = 6;
	int elevatorControl = 9;
	Button home = new JoystickButton(mechController, buttonHome);
    Button portal = new JoystickButton(mechController, buttonPortal);
    Button switche = new JoystickButton(mechController, buttonSwitch);
    Button scale = new JoystickButton(mechController, buttonScale);
    Button climb = new JoystickButton(mechController, buttonClimb);
    Button climbSafety = new JoystickButton(mechController, buttonClimbSafety);
  
    
    public double elevatorControl() 
 	{
 		return mechController.getRawAxis(elevatorControl);
 	}
   
    public double returnRetriever()
    {
    	return mechController.getRawAxis(intakeTrigger);
    }
    
    public double returnShooter()
    {
    	return mechController.getRawAxis(outtakeTrigger);
    }
    
 
    public double leftSide()
    {
    	return leftStick.getY();
    }
    
    public double rightSide()
    {
    	return rightStick.getY();
    }
    
	
	public OI() {
		
		
		

		home.whenPressed(new MoveElevator(0));
		switche.whenPressed(new MoveElevator(1));
		portal.whenPressed(new MoveElevator(2));
		scale.whenPressed(new MoveElevator(3));
		climb.whenPressed(new MoveElevator(4));
		climbSafety.toggleWhenPressed(new ToggleRatchet());
	}

	
	
}
