package org.usfirst.frc.team5002.robot.commands;

import org.usfirst.frc.team5002.robot.Robot;
import org.usfirst.frc.team5002.robot.OI;
import org.usfirst.frc.team5002.robot.subsystems.SwerveDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author sebastian and bri
 * PIDSteerCollective -- Steer all swerve modules collectively.
 */
public class PIDSteerCollective extends Command {
	
	private static final double joystickDeadband = 0.10;
	private static final double maxDriveOutput = 1.0;
	//setting limits and max output
	
	
	private double dir = 0;
	
	protected void execute(){
		if(Robot.oi.arcadeStick.getRawButton(1)) {
			dir = Robot.oi.arcadeStick.getDirectionDegrees();
		}
		
		Robot.drivetrain.setSteerDegrees(SwerveDrive.ModulePosition.FL, dir);
		Robot.drivetrain.setSteerDegrees(SwerveDrive.ModulePosition.FR, dir);
		Robot.drivetrain.setSteerDegrees(SwerveDrive.ModulePosition.BL, dir);
		Robot.drivetrain.setSteerDegrees(SwerveDrive.ModulePosition.BR, dir);
	}

	public PIDSteerCollective() {
		requires(Robot.drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drivetrain.bl_steer.clearIAccum();
		/*
		Robot.drivetrain.fl_steer.setPosition(0);
		Robot.drivetrain.bl_steer.setPosition(0);
		Robot.drivetrain.br_steer.setPosition(0);
		Robot.drivetrain.fr_steer.setPosition(0);
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
