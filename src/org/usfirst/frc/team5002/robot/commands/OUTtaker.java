package org.usfirst.frc.team5002.robot.commands;

import org.usfirst.frc.team5002.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *@author (Jo)Nathan, Bri
 *@version Last Updated 2/7/17
 */
public class OUTtaker extends Command {

    public OUTtaker() {
        requires(Robot.intake);
    }

    protected void initialize() {
    }

    protected void execute() {							//Makes motor go backward when activated
        Robot.intake.runBackwards();

    }

    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}