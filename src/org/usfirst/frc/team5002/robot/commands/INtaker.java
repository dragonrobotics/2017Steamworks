
package org.usfirst.frc.team5002.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5002.robot.Robot;

/**
 *@author (Jo)Nathan, elweb
 *@version Last Updated 2/8/17
 */
public class INtaker extends Command {

    public INtaker() {
        requires(Robot.intake);
    }

    protected void initialize() {		//Makes motor start at 0
    	SmartDashboard.putBoolean("Intaker", true);
    }

    protected void execute() {
        Robot.intake.run();			//Makes motor go forward when activated
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stop();
    	SmartDashboard.putBoolean("Intaker", false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
