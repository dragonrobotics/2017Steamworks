package org.usfirst.frc.team5002.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5002.robot.Robot;

/**
 *@author (Jo)Nathan
 *@version Last Updated 1/19/17
 */
public class INtaker extends Command {

    public INtaker() {
        requires(Robot.intake);
    }

    protected void initialize() {
        Robot.intake.motorGo(0);			//Makes motor start at 0

    }

    protected void execute() {
        Robot.intake.motorGo(1);			//Makes motor go forward when activated
    	
    }

    // Make this return true when this Command no longer needs to run execute()
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
