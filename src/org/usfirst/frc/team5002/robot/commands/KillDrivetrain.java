package org.usfirst.frc.team5002.robot.commands;

import org.usfirst.frc.team5002.robot.Robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;

/**
 * KillDrivetrain.java -- the usual safety stuff
 * @author sebastian mobo
 */
public class KillDrivetrain extends Command {

    public KillDrivetrain() {
    	requires(Robot.drivetrain);
    	//get the right info from the right places
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	/*
    	Robot.drivetrain.fl_drive.set(0.0);
    	Robot.drivetrain.fr_drive.set(0.0);
    	Robot.drivetrain.bl_drive.set(0.0);
    	Robot.drivetrain.br_drive.set(0.0);
    	*/
    	//sets all motors to zero, stops the motors
  
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
