package org.usfirst.frc.team5002.robot.commands;

import org.usfirst.frc.team5002.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *@author (Jo)Nathan
 *@version Last Updated 1/19/17
 */
public class OUTtaker extends Command {

    public OUTtaker() {
        requires(Robot.intake);
    }

    protected void initialize() {
        Robot.intake.motorGo(0);						//Makes motor start at 0

    }

    protected void execute() {							//Makes motor go backward when activated
        Robot.intake.motorGo(-1);

    }

    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
