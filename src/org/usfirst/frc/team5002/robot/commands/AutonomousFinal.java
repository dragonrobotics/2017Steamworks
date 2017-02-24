package org.usfirst.frc.team5002.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5002.robot.subsystems.SwerveDrive;
import org.usfirst.frc.team5002.robot.subsystems.*;
import org.usfirst.frc.team5002.robot.*;


/**
 * @author Grace
 */
public class AutonomousFinal extends Command {

    public AutonomousFinal() {
    	
    	requires(Robot.drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/* Set main controls for driving... */
    	Robot.drivetrain.setDriveAuto();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//variable x is equal to the distance in feet(x12) divded by 12.56
    	//change the first number to the feet you want
    	double x = (6.4*12)/12.56;
    	
    	
    	//set all the motors in the drivetrain to the variable x, and itll run forward
    	/*
    	Robot.drivetrain.fl_drive.set(x);
    	Robot.drivetrain.fr_drive.set(x);
    	Robot.drivetrain.bl_drive.set(x);
    	Robot.drivetrain.br_drive.set(x);
    	*/
    	
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
