package org.usfirst.frc.team2554.robot.commands.auto;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.commands.Claw.ShootCube;
import org.usfirst.frc.team2554.robot.commands.Claw.Shooter;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.RotateToAngle;
import org.usfirst.frc.team2554.robot.commands.Elevator.MoveElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *CHANGGEEEE THIS 
 */
public class OppositeSideSwitch extends CommandGroup {

    public OppositeSideSwitch(int side) {
       
    	//addSequential(new DriveStraight(18.17, 0.82, true, side*0));
		//addSequential(new RotateToAngle(-90*side));
		//addSequential(new DriveStraight(21, 0.82, true, -90*side));
		//addSequential(new RotateToAngle(-180*side));
		//addSequential(new DriveStraight(6.084,0.7, true, -180*side));
		addSequential(new RotateToAngle(90*side));
		//addSequential(new MoveElevator(1));
		//addSequential(new DriveStraight(4, 0.82, true, 90*side));
		
        //addSequential(new ShootCube(3));
    }
}
