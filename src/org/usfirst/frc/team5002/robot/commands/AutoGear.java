package org.usfirst.frc.team5002.robot.commands;

import org.usfirst.frc.team5002.robot.Robot;
import org.usfirst.frc.team5002.robot.subsystems.SwerveDrive;
import org.usfirst.frc.team5002.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class AutoGear extends Command {
    public static final double targetDistance = 20.0; // cm
    public static final double distThreshold = 3.5;   // stop when closer than (targetDistance +- distThreshold)
    public static final double alignThreshold = 5.0;  // maximum diff. between left and right sensor distances

    public static final double driveSpeed = 0.25;   // forward/back drive speed (for adjusting distance to wall)
    public static final double alignSpeed = 0.1;    // left/right drive turn speed (for adjusting angle to wall)

	public AutoGear() {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.drivetrain.setSteerDegreesCollective(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        autoGearAlign();
    }

    public static void autoGearAlign() {
        double dist = (Robot.sensors.getLeftDistance() + Robot.sensors.getRightDistance()) / 2;

        if(Math.abs(Robot.sensors.getLeftDistance() - Robot.sensors.getRightDistance()) >= alignThreshold) {
            /* Adjust angle to target: */

            /* Set swerve modules to turning (mechanum-esque) configuration: */
        	Robot.drivetrain.setSteerDegrees(SwerveDrive.ModulePosition.FL, 45.0);
        	Robot.drivetrain.setSteerDegrees(SwerveDrive.ModulePosition.FR, 135.0);
        	Robot.drivetrain.setSteerDegrees(SwerveDrive.ModulePosition.BL, -45.0);
        	Robot.drivetrain.setSteerDegrees(SwerveDrive.ModulePosition.BR, -135.0);

            if(Robot.sensors.getLeftDistance() > Robot.sensors.getRightDistance()) {
                Robot.drivetrain.setDriveSpeedCollective(-alignSpeed); // CCW rotation
            } else {
                Robot.drivetrain.setDriveSpeedCollective(alignSpeed); // CW rotation
            }
        } else if(Math.abs(dist - targetDistance) >= distThreshold) {
            /* Adjust distance to target: */
            Robot.drivetrain.setSteerDegreesCollective(0);
            if(dist > targetDistance) {
                Robot.drivetrain.setDriveSpeedCollective(driveSpeed);
            } else if(dist < targetDistance) {
                Robot.drivetrain.setDriveSpeedCollective(-driveSpeed);
            }
        }
    }

    public static boolean finished() {
        double dist = (Robot.sensors.getLeftDistance() + Robot.sensors.getRightDistance()) / 2;
        if(Math.abs(Robot.sensors.getLeftDistance() - Robot.sensors.getRightDistance()) >= alignThreshold) {
            return false;
        } else if(Math.abs(dist - targetDistance) < distThreshold) {
            return true;
        }

        return false;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drivetrain.setDriveSpeedCollective(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.drivetrain.setDriveSpeedCollective(0);
    }
}
