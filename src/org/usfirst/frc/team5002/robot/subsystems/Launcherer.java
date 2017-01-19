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
    

    public void initDefaultCommand() {
    	
    	//not sure
    	
    }
    
    public Launcherer(){
    	
    	launcherer = new CANTalon(784);
    	//TODO: Input atual port number
    	//setting our motor to a port number
    	//784 is just a placeholder
    	launcherer.changeControlMode(TalonControlMode.Speed);
    	//making sure our motor control is in speed (easier)
    	
    }
    
    public void callMotors(double speedThing){
    	//making a method to define and be able to change the speed in the LaunchererC command
    	
    	launcherer.set(speedThing);
    	//gives us a variable that can be changed for the speed inside the LaunchererC command
    	
    	
    }
    
  
    
    
}

