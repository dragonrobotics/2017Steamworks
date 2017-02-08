package org.usfirst.frc.team5002.robot.subsystems;

/**
 * @author Grace/Justice/Justice/Grace
*/
import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

//imports for stuff


import edu.wpi.first.wpilibj.command.Subsystem;

//imported ourselves

/**
 *
 */
public class Launcherer extends Subsystem {
	//extending subsystem, just organization

    private CANTalon launcherer;
    //setting our motor name
    public Launcherer(){
    	
    	launcherer = new CANTalon(784); //TODO: Input actual port number
    	//setting our motor to a port number
    	launcherer.changeControlMode(TalonControlMode.PercentVbus);
    	//making sure our motor control is in speed (easier)
    	
    }

    public void initDefaultCommand() {
    }
    
    public void run(){
    	//making a method to define and be able to change the speed in the LaunchererC command
    	launcherer.set(1.0);
    	//gives us a variable that can be changed for the speed inside the LaunchererC command	
    	
    }
    public void stop() {
		launcherer.set(0);
	}
    
  
    
    
}
