package org.usfirst.frc.team5002.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon.TalonControlMode;
/**
 *@author elweb & Jonathan 
 *@version Last Modified  2/7/17
 */
public class RopeClimber extends Subsystem {

    private CANTalon ropeClimb;

    public void initDefaultCommand() {
    }
    public RopeClimber(){
    	ropeClimb = new CANTalon(3);//TODO input actual port number
    	ropeClimb.changeControlMode(TalonControlMode.PercentVbus);
    	}
    public void run(){
    	ropeClimb.set(0.5);
    }
    public void runBackwards(){
    	ropeClimb.set(0.5);
    }
    public void stop(){
    	ropeClimb.set(0);
    }
}

