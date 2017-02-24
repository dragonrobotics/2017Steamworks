package org.usfirst.frc.team5002.robot.commands;

import org.usfirst.frc.team5002.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SteerTestVbus extends Command {

    public SteerTestVbus() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/*
    	Robot.drivetrain.bl_steer.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.drivetrain.br_steer.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.drivetrain.fl_steer.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.drivetrain.fr_steer.changeControlMode(TalonControlMode.PercentVbus);
    	*/
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double derp = Robot.oi.arcadeStick.getRawAxis(0);
    	/*
    	Robot.drivetrain.bl_steer.set(derp);
    	Robot.drivetrain.br_steer.set(derp);
    	Robot.drivetrain.fl_steer.set(derp);
    	Robot.drivetrain.fr_steer.set(derp);
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
