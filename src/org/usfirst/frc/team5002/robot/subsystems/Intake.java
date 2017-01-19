package org.usfirst.frc.team5002.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *@author (Jo)Nathan
 *@version Last Updated 1/19/17
 */
public class Intake extends Subsystem {

	
	private CANTalon intake;
	 
	
	public void motorGo(double percentSpeed){ 	//Call to change the motor speed
		
		intake.set(percentSpeed);
	}
		
    public void initDefaultCommand() {
    	
    }
    public Intake(){ 							//Creation of intake motor
    	intake = new CANTalon(712);
    	intake.changeControlMode(TalonControlMode.Speed);
    }
}

