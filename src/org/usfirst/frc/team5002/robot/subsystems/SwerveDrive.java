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
    // The actual steer motors...
	private CANTalon fl_steer;
	private CANTalon fr_steer;
	public CANTalon bl_steer;
	private CANTalon br_steer;

    // The main drive motors...
    private CANTalon fl_drive;
    private CANTalon fr_drive;
    private CANTalon bl_drive;
    private CANTalon br_drive;

    /* Steering zero positions:
     *  FL: -0.54,
     *  FR: -0.04,
     *  BL: -0.35,
     *  BR: -0.33
     */
    
    /*
     * Control system values:
     * (P/I/D/FeedFwd/IZone/RampRate)
     * FL: 28 / 0.00125 / 300 / 0 / 512  / 15
     * FR: 12 / 0.0015  / 300 / 0 / 1023 / 25
     * BL: 24 / 0.0015  / 720 / 0 / 2048 / 10
     * BR: 24 / 0.0015  / 350 / 0 / 0    / 15
     */
    
    /* FrontLeft, FrontRight, BackLeft, BackRight */
    private double[] steer_offsets = { 133.0, 536.0, 802.0/*814.0*/, 582.0 };
    private double[] maxEncoderOutput = {881.0, 880.0, 871.0, 882.0};
    boolean driveReversalStatus[] = {true, false, true, false};
    
    public enum ModulePosition {
    	FL,
    	FR,
    	BL,
    	BR
    };
    
    private double getSteerHack(ModulePosition pos) {
    	switch(pos) {
    	case FL:
    		return maxEncoderOutput[0];
    	case FR:
    		return maxEncoderOutput[1];
    	case BL:
    		return maxEncoderOutput[2];
    	case BR:
    		return maxEncoderOutput[3];
    	}
    	
    	return 1024;
    }
    
    private double getSteerOffset(ModulePosition pos) {
    	switch(pos) {
    	case FL:
    		return steer_offsets[0];
    	case FR:
    		return steer_offsets[1];
    	case BL:
    		return steer_offsets[2];
    	case BR:
    		return steer_offsets[3];
    	}
    	
    	return 0;
    }
    
    private boolean getDriveReverse(ModulePosition pos) {
    	switch(pos) {
    	case FL:
    		return driveReversalStatus[0];
    	case FR:
    		return driveReversalStatus[1];
    	case BL:
    		return driveReversalStatus[2];
    	case BR:
    		return driveReversalStatus[3];
    	}
    	
    	return false;
    }
    
    private CANTalon getSteerController(ModulePosition pos) {
    	switch(pos) {
    	case FL:
    		return fl_steer;
    	case FR:
    		return fr_steer;
    	case BL:
    		return bl_steer;
    	case BR:
    		return br_steer;
    	}
    	
    	return null;
    }
    
    private CANTalon getDriveController(ModulePosition pos) {
    	switch(pos) {
    	case FL:
    		return fl_drive;
    	case FR:
    		return fr_drive;
    	case BL:
    		return bl_drive;
    	case BR:
    		return br_drive;
    	}
    	
    	return null;
    }
    
	public SwerveDrive() {
    	/* Init steer (swerve? motor-turner?) motors */
        fl_steer = new CANTalon(RobotMap.fl_steer);
        fr_steer = new CANTalon(RobotMap.fr_steer);
        bl_steer = new CANTalon(RobotMap.bl_steer);
        br_steer = new CANTalon(RobotMap.br_steer);

		this.configureSteerMotor(fr_steer, false);
        this.configureSteerMotor(fl_steer, false);
        this.configureSteerMotor(bl_steer, false);
        this.configureSteerMotor(br_steer, false);

        /* Init drive motors... */
        fl_drive = new CANTalon(RobotMap.fl_drive);
        fr_drive = new CANTalon(RobotMap.fr_drive);
        bl_drive = new CANTalon(RobotMap.bl_drive);
        br_drive = new CANTalon(RobotMap.br_drive);

        /* Drive motor config is left to teleop/auto commands */
    }

    private void configureSteerMotor(CANTalon srx, boolean reverse) {
    	srx.changeControlMode(TalonControlMode.Position);
    	srx.setFeedbackDevice(FeedbackDevice.AnalogEncoder);
    	//srx.configPotentiometerTurns(1);
		srx.setProfile(0);
        //srx.setPosition(0);
		srx.reverseOutput(reverse);
		//srx.set(0.5); // reset to midpoint
    }
    
    private void configureDriveMotorTeleop(ModulePosition pos) {
    	CANTalon srx = getDriveController(pos);
    	srx.reverseOutput(getDriveReverse(pos));
    	srx.changeControlMode(TalonControlMode.PercentVbus);
    	srx.set(0); // Reset to stopped
    }

    private void configureDriveMotorAutonomous(ModulePosition pos) {
    	CANTalon srx = getDriveController(pos);
    	
    	srx.changeControlMode(TalonControlMode.Position);
    	//control mode is in position
    	srx.reverseOutput(getDriveReverse(pos));
    	//making the sensor read positively
    	srx.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	//making it a quad encoder
    	srx.configEncoderCodesPerRev(40);
    }
    
    public void setDriveOutput(ModulePosition pos, double vout) {
    	CANTalon drive = getDriveController(pos);
    	drive.set(vout);
    }
    
    public void setSteerDegrees(ModulePosition pos, double degrees) {
    	CANTalon steer = getSteerController(pos);
    	CANTalon drive = getDriveController(pos);
    	
    	/*
    	if(degrees >= 180.0) {
    		degrees -= 180.0;
    		drive.reverseOutput(!getDriveReverse(pos));
    	} else {
    		drive.reverseOutput(getDriveReverse(pos));
    	}
    	*/
    	
    	double nativePos = degrees * (getSteerHack(pos) / 360.0);
    	nativePos += getSteerOffset(pos);
    	
    	steer.set(nativePos);
    }
    
    public void setDriveTeleop() {
    	configureDriveMotorTeleop(ModulePosition.FL);
    	configureDriveMotorTeleop(ModulePosition.FR);
    	configureDriveMotorTeleop(ModulePosition.BL);
    	configureDriveMotorTeleop(ModulePosition.BR);
    }
    
    public void setDriveAuto() {
    	configureDriveMotorAutonomous(ModulePosition.FL);
    	configureDriveMotorAutonomous(ModulePosition.FR);
    	configureDriveMotorAutonomous(ModulePosition.BL);
    	configureDriveMotorAutonomous(ModulePosition.BR);
    }

    public void initDefaultCommand() {
    	this.setDefaultCommand(new KillDrivetrain());
    }
    
    public void UpdateSDSingle(CANTalon srx) {
    	SmartDashboard.putNumber("Error", srx.getClosedLoopError());
    	SmartDashboard.putNumber("Pos", srx.getPosition());
    	SmartDashboard.putNumber("ADC", srx.getAnalogInRaw());
    }

    /*
     * sends data to the SmartDashboard
     */
    public void updateSD(){
    	SmartDashboard.putNumber("ADC-FR", fr_steer.getAnalogInRaw());
    	SmartDashboard.putNumber("ADC-FL", fl_steer.getAnalogInRaw());
    	SmartDashboard.putNumber("ADC-BL", bl_steer.getAnalogInRaw());
    	SmartDashboard.putNumber("ADC-BR", br_steer.getAnalogInRaw());
    	
    	SmartDashboard.putNumber("Pos-FR", fr_steer.getPosition());
    	SmartDashboard.putNumber("Pos-FL", fl_steer.getPosition());
    	SmartDashboard.putNumber("Pos-BL", bl_steer.getPosition());
    	SmartDashboard.putNumber("Pos-BR", br_steer.getPosition());
    	
    	SmartDashboard.putNumber("Err-FR", fr_steer.getClosedLoopError());
    	SmartDashboard.putNumber("Err-FL", fl_steer.getClosedLoopError());
    	SmartDashboard.putNumber("Err-BL", bl_steer.getClosedLoopError());
    	SmartDashboard.putNumber("Err-BR", br_steer.getClosedLoopError());
    	
    	SmartDashboard.putNumber("AccErr-BL", bl_steer.GetIaccum());
    	
    	SmartDashboard.putNumber("Pos-DriveFR", fr_drive.getPosition());
    	SmartDashboard.putNumber("Pos-DriveFL", fl_drive.getPosition());
    	SmartDashboard.putNumber("Pos-DriveBL", bl_drive.getPosition());
    	SmartDashboard.putNumber("Pos-DriveBR", br_drive.getPosition());
    	
    	SmartDashboard.putNumber("DriveFR Speed", fr_drive.getSpeed());
    	SmartDashboard.putNumber("DriveFL Speed", fl_drive.getSpeed());
    	SmartDashboard.putNumber("DriveBL Speed", bl_drive.getSpeed());
    	SmartDashboard.putNumber("DriveBR Speed", br_drive.getSpeed());
    	
    }
}
