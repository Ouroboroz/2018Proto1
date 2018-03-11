package org.usfirst.frc.team2554.robot.commands.auto;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.DistanceDriveFinal;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.DriveStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SideLineCross extends CommandGroup {

    public SideLineCross() {
        addSequential(new DriveStraight(13.5, Robot.driveTrain.MinSpeed, true, 0));
    }
}
