
package org.usfirst.frc.team5002.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5002.robot.commands.Teleop;
import org.usfirst.frc.team5002.robot.commands.KillDrivetrain;
import org.usfirst.frc.team5002.robot.commands.PIDSteerCollective;
import org.usfirst.frc.team5002.robot.commands.PIDSteerTestSingle;
import org.usfirst.frc.team5002.robot.commands.SteerTestVbus;
import org.usfirst.frc.team5002.robot.subsystems.Intake;
import org.usfirst.frc.team5002.robot.subsystems.Launcherer;
import org.usfirst.frc.team5002.robot.subsystems.Outtake;
import org.usfirst.frc.team5002.robot.subsystems.RopeClimber;
import org.usfirst.frc.team5002.robot.subsystems.SwerveDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final SwerveDrive drivetrain = new SwerveDrive();
	public static final Intake intake = new Intake();
	public static final Launcherer launcherer = new Launcherer();
	public static final RopeClimber ropeClimber = new RopeClimber();
	public static final Outtake outtake = new Outtake();
	public static OI oi;

	public static AHRS navx;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		
		try {
			/* NOTE: With respect to the NavX, the robot's front is in the -X direction.
			 * The robot's right side is in the +Y direction, 
			 * and the robot's top side is in the +Z direction as usual. */
			navx = new AHRS(Port.kMXP);
		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
			navx = null;
		}

		/* Add PID Test commands. */
		/*
		SmartDashboard.putData("PIDSteerTest-FrontLeft", new PIDSteerTestSingle(drivetrain.fl_steer));
		SmartDashboard.putData("PIDSteerTest-FrontRight", new PIDSteerTestSingle(drivetrain.fr_steer));
		SmartDashboard.putData("PIDSteerTest-BackLeft", new PIDSteerTestSingle(drivetrain.bl_steer));
		SmartDashboard.putData("PIDSteerTest-BackRight", new PIDSteerTestSingle(drivetrain.br_steer));
		*/
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		/*
		SmartDashboard.putNumber("FL-Pos", Robot.drivetrain.fl_steer.getPosition());
		SmartDashboard.putNumber("FR-Pos", Robot.drivetrain.fr_steer.getPosition());
		SmartDashboard.putNumber("BL-Pos", Robot.drivetrain.bl_steer.getPosition());
		SmartDashboard.putNumber("BR-Pos", Robot.drivetrain.br_steer.getPosition());
		*/
		
		//Robot.drivetrain.UpdateSDSingle(Robot.drivetrain.fr_steer);
		//Robot.drivetrain.UpdateSDSingle(Robot.drivetrain.fl_steer);
		
		Robot.drivetrain.updateSD();
		
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = new KillDrivetrain();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Robot.drivetrain.updateSD();
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();

		PIDSteerCollective PIDTest = new PIDSteerCollective();
		Scheduler.getInstance().add(PIDTest);
		
		//Teleop teleopTest = new Teleop();
		//Scheduler.getInstance().add(teleopTest);
		//
		
		//Command test = new SteerTestVbus();
		//Scheduler.getInstance().add(test);
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		//Robot.oi.testing();
		Robot.drivetrain.updateSD();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
