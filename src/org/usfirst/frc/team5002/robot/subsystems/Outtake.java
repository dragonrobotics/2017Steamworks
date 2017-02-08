package org.usfirst.frc.team5002.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon.TalonControlMode;

/**@author elweb 
 * @version Last Modified 2/8/17
 *
 */
public class Outtake extends Subsystem {

    private CANTalon outtake;
    public Outtake(){
    	outtake = new CANTalon(8); //TODO replace with real controller ID
    	outtake.changeControlMode(TalonControlMode.PercentVbus);
    }

    public void initDefaultCommand() {
    }
    public void run(){
    	outtake.set(1.0);
    }
    public void runBackwards(){
    	outtake.set(-1.0);
    }
    public void stop(){
    	outtake.set(0);
    }
}

