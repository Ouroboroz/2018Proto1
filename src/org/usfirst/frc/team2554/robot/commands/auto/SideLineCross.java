package org.usfirst.frc.team2554.robot.commands.auto;

import org.usfirst.frc.team2554.robot.commands.DriveTrain.DistanceDriveFinal;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SideLineCross extends CommandGroup {

    public SideLineCross() {
        addSequential(new DistanceDriveFinal(13.5));
    }
}
