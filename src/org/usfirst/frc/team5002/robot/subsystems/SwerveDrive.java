package org.usfirst.frc.team5002.robot.subsystems;

import org.usfirst.frc.team5002.robot.RobotMap;
import org.usfirst.frc.team5002.robot.commands.KillDrivetrain;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTablesJNI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author stmobo @version Last Modified 1/18/17
 * SwerveDrive.java -- swerve drive subsystem
 */
public class SwerveDrive extends Subsystem {

    public enum ModulePosition {
      FRONT_LEFT,
      FRONT_RIGHT,
      BACK_LEFT,
      BACK_RIGHT
    }

    // The actual steer motors...
    public CANTalon fl_steer;
    public CANTalon fr_steer;
    public CANTalon bl_steer;
    public CANTalon br_steer;

    // The main drive motors...
    private CANTalon fl_drive;
    private CANTalon fr_drive;
    private CANTalon bl_drive;
    private CANTalon br_drive;

	private static boolean reverse_fl_steer = false;
	private static boolean reverse_fr_steer = false;
	private static boolean reverse_bl_steer = false;
	private static boolean reverse_br_steer = false;

	private static boolean reverse_fl_drive = false;
	private static boolean reverse_fr_drive = true;
	private static boolean reverse_bl_drive = false;
	private static boolean reverse_br_drive = true;

	public SwerveDrive() {
    	/* Init steer (swerve? motor-turner?) motors */
        fl_steer = new CANTalon(RobotMap.fl_steer);
        fr_steer = new CANTalon(RobotMap.fr_steer);
        bl_steer = new CANTalon(RobotMap.bl_steer);
        br_steer = new CANTalon(RobotMap.br_steer);

        this.configureSteerMotor(fl_steer);
        this.configureSteerMotor(fr_steer);
        this.configureSteerMotor(bl_steer);
        this.configureSteerMotor(br_steer);

        /* Init drive motors... */
        fl_drive = new CANTalon(RobotMap.fl_drive);
        fr_drive = new CANTalon(RobotMap.fr_drive);
        bl_drive = new CANTalon(RobotMap.bl_drive);
        br_drive = new CANTalon(RobotMap.br_drive);

        /* Set main controls for driving... */
        this.configureDriveMotor(fl_drive);
        this.configureDriveMotor(fr_drive);
        this.configureDriveMotor(bl_drive);
        this.configureDriveMotor(br_drive);
    }

    private void configureSteerMotor(CANTalon srx) {
    	srx.changeControlMode(TalonControlMode.Position);
    	srx.setFeedbackDevice(FeedbackDevice.AnalogEncoder);
    	srx.configPotentiometerTurns(1);
		srx.setProfile(0);
		srx.setPosition(0);
    	//srx.set(0); // Reset to initial position
    }

    /* Testing only! */
    public void reconfigureSteer_vbus(ModulePosition mod) {
    	switch(mod) {
    	case FRONT_LEFT:
    		configureDriveMotor(fl_steer);
    		return;
    	case FRONT_RIGHT:
    		configureDriveMotor(fr_steer);
    		return;
    	case BACK_LEFT:
    		configureDriveMotor(bl_steer);
    		return;
    	case BACK_RIGHT:
    		configureDriveMotor(br_steer);
    		return;
    	}
    }

    private void configureDriveMotor(CANTalon srx) {
    	srx.changeControlMode(TalonControlMode.PercentVbus);
    	srx.set(0); // Reset to initial position
    }

    public void setDriveOutput(double vbus_fl, double vbus_fr, double vbus_bl, double vbus_br) {
    	fl_drive.set(vbus_fl * (this.reverse_fl_drive ? -1 : 1));
    	fr_drive.set(vbus_fr * (this.reverse_fr_drive ? -1 : 1));
    	bl_drive.set(vbus_bl * (this.reverse_bl_drive ? -1 : 1));
    	br_drive.set(vbus_br * (this.reverse_br_drive ? -1 : 1));
    }

    public void setSteerPosition_rev(double pos_fl, double pos_fr, double pos_bl, double pos_br) {
    	fl_steer.set(pos_fl * (this.reverse_fl_steer ? -1 : 1));
    	fr_steer.set(pos_fr * (this.reverse_fr_steer ? -1 : 1));
    	bl_steer.set(pos_bl * (this.reverse_bl_steer ? -1 : 1));
    	br_steer.set(pos_br * (this.reverse_br_steer ? -1 : 1));
    }

	public void setSteerPosition_deg(double pos_fl, double pos_fr, double pos_bl, double pos_br) {
    	fl_steer.set(pos_fl/360.0 * (this.reverse_fl_steer ? -1 : 1));
    	fr_steer.set(pos_fr/360.0 * (this.reverse_fr_steer ? -1 : 1));
    	bl_steer.set(pos_bl/360.0 * (this.reverse_bl_steer ? -1 : 1));
    	br_steer.set(pos_br/360.0 * (this.reverse_br_steer ? -1 : 1));
    }

    public void setSteerPosition_rev(ModulePosition mod, double pos) {
    	switch(mod) {
    	case FRONT_LEFT:
    		fl_steer.set(pos * (this.reverse_fl_steer ? -1 : 1));
    		return;
    	case FRONT_RIGHT:
    		fr_steer.set(pos * (this.reverse_fr_steer ? -1 : 1));
    		return;
    	case BACK_LEFT:
    		bl_steer.set(pos * (this.reverse_bl_steer ? -1 : 1));
    		return;
    	case BACK_RIGHT:
    		br_steer.set(pos * (this.reverse_br_steer ? -1 : 1));
    		return;
		default:
			return;
    	}
    }

	public void setSteerPosition_deg(ModulePosition mod, double pos) {
    	switch(mod) {
    	case FRONT_LEFT:
    		fl_steer.set(pos/360.0 * (this.reverse_fl_steer ? -1 : 1));
    		return;
    	case FRONT_RIGHT:
    		fr_steer.set(pos/360.0 * (this.reverse_fr_steer ? -1 : 1));
    		return;
    	case BACK_LEFT:
    		bl_steer.set(pos/360.0 * (this.reverse_bl_steer ? -1 : 1));
    		return;
    	case BACK_RIGHT:
    		br_steer.set(pos/360.0 * (this.reverse_br_steer ? -1 : 1));
    		return;
		default:
			return;
    	}
    }

    public void initDefaultCommand() {
    	this.setDefaultCommand(new KillDrivetrain());
    }

    /*
     * sends data to the SmartDashboard
     */
    public void UpdateSD(){
    	SmartDashboard.putNumber("SteerFL get", fl_steer.get());
		SmartDashboard.putNumber("SteerFR get", fr_steer.get());
		SmartDashboard.putNumber("SteerBL get", bl_steer.get());
		SmartDashboard.putNumber("SteerBR get", br_steer.get());
		//necessary to begin collecting data from the motors that control the rotation of the wheels
		SmartDashboard.putNumber("DriveFL get", fl_drive.get());
		SmartDashboard.putNumber("DriveFR get", fr_drive.get());
		SmartDashboard.putNumber("DriveBL get", bl_drive.get());
		SmartDashboard.putNumber("DriveBR get", br_drive.get());
		//necessary to begin collecting data from the motors that drive the wheels
		SmartDashboard.putNumber("DriveFL BusVoltage", fl_drive.getBusVoltage());
		SmartDashboard.putNumber("DriveFR BusVoltage", fr_drive.getBusVoltage());
		SmartDashboard.putNumber("DriveBL BusVoltage", bl_drive.getBusVoltage());
		SmartDashboard.putNumber("DriveBR BusVoltage", br_drive.getBusVoltage());
		//Measures the voltage distributed to the motors
		SmartDashboard.putNumber("DriveFL ClosedLoopError", fl_drive.getClosedLoopError());
		SmartDashboard.putNumber("DriveFR ClosedLoopError", fr_drive.getClosedLoopError());
		SmartDashboard.putNumber("DriveBL ClosedLoopError", bl_drive.getClosedLoopError());
		SmartDashboard.putNumber("DriveBR ClosedLoopError", br_drive.getClosedLoopError());
		//Displays an error if the drive loop is broken
		SmartDashboard.putNumber("DriveFL OutputVoltage", fl_drive.getOutputVoltage());
		SmartDashboard.putNumber("DriveFR OutputVoltage", fr_drive.getOutputVoltage());
		SmartDashboard.putNumber("DriveBL OutputVoltage", bl_drive.getOutputVoltage());
		SmartDashboard.putNumber("DriveBR OutputVoltage", br_drive.getOutputVoltage());
		//measure the actual voltage the motor receives
		SmartDashboard.putNumber("DriveFL OutputCurrent", fl_drive.getOutputCurrent());
		SmartDashboard.putNumber("DriveFR OutputCurrent", fr_drive.getOutputCurrent());
		SmartDashboard.putNumber("DriveBL OutputCurrent", bl_drive.getOutputCurrent());
		SmartDashboard.putNumber("DriveBR OutputCurrent", br_drive.getOutputCurrent());
		//measures the amperage the motor receives (so we don't burn through the insulation on the wires)
		SmartDashboard.putNumber("SteerFL OutputVoltage", fl_steer.getOutputVoltage());
		SmartDashboard.putNumber("SteerFR OutputVoltage", fr_steer.getOutputVoltage());
		SmartDashboard.putNumber("SteerBL OutputVoltage", bl_steer.getOutputVoltage());
		SmartDashboard.putNumber("SteerBR OutputVoltage", br_steer.getOutputVoltage());
		//measures the voltage the steer motors receive
		SmartDashboard.putNumber("SteerFL OutputCurrent", fl_steer.getOutputCurrent());
		SmartDashboard.putNumber("SteerFR OutputCurrent", fr_steer.getOutputCurrent());
		SmartDashboard.putNumber("SteerBL OutputCurrent", bl_steer.getOutputCurrent());
		SmartDashboard.putNumber("SteerBR OutputCurrent", br_steer.getOutputCurrent());
		//measures the amperage the steer motors receive

    }
}
