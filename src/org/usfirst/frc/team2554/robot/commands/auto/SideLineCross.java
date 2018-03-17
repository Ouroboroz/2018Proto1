package org.usfirst.frc.team2554.robot.commands.Auto;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.commands.DriveTrain.DriveStraight;
import org.usfirst.frc.team2554.robot.commands.Relics.DistanceDriveFinal;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SideLineCross extends CommandGroup {

    public SideLineCross() {
        addSequential(new DriveStraight(150/12, Robot.driveTrain.MinSpeed, true, 0));
    }
}
