package org.usfirst.frc.team2554.robot.commands.auto;

import org.usfirst.frc.team2554.robot.commands.MoveElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SameSideSwitch extends CommandGroup {

    public SameSideSwitch(int side) {
       addParallel(new MoveElevator(1));
    }
}
