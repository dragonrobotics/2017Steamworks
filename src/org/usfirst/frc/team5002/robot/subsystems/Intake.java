package org.usfirst.frc.team5002.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *@author (Jo)Nathan, Bri, elweb
 *@version Last Updated 2/8/17
 *motor that picks balls up off the ground
 */
public class Intake extends Subsystem {
	private CANTalon intake;
	
	public Intake(){ 							//Creation of intake motor
	    	intake = new CANTalon(42); //TODO: put actual motor id
	    	intake.changeControlMode(TalonControlMode.PercentVbus);
	    }
	
	public void initDefaultCommand() {	
	    }
	 
	public void run(){ 	//Call to change the motor speed
		intake.set(1.0);
	}
	public void runBackwards(){
		intake.set(-1.0);
	}
	public void stop() {  // stops the motor
		intake.set(0);
	}   
}
