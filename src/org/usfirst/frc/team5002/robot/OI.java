package org.usfirst.frc.team5002.robot;

import org.usfirst.frc.team5002.robot.commands.ClimbUp;
import org.usfirst.frc.team5002.robot.commands.INtaker;
import org.usfirst.frc.team5002.robot.commands.LaunchererC;
import org.usfirst.frc.team5002.robot.commands.OUTtaker;
import org.usfirst.frc.team5002.robot.commands.ReverseInTaker;
import org.usfirst.frc.team5002.robot.commands.TakeOuter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 * @author elweb @version Last Modified 1/18/17
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick arcadeStick; //named Joystick
	
	
	public OI(){
		arcadeStick = new Joystick(0); //gave Joystick a job
		Button A = new JoystickButton(arcadeStick, 1);
		Button B = new JoystickButton(arcadeStick, 2);
		Button X = new JoystickButton(arcadeStick, 3);
		Button Y = new JoystickButton(arcadeStick, 4);
		Button LB = new JoystickButton(arcadeStick, 5);
		Button RB = new JoystickButton(arcadeStick, 6);
		Button home = new JoystickButton(arcadeStick, 7);
		Button menu = new JoystickButton(arcadeStick, 8);
		
		Y.toggleWhenActive(new ClimbUp());//turns the climb motor on while Y is being held, but reverses the motor while the button is held down the second time (for emergencies)
		B.toggleWhenPressed(new LaunchererC());//turns launcher motor on when B is pressed once, and off when B is pressed again

		A.toggleWhenPressed(new INtaker()); //turns the intake motor on when A is pressed once, and off when A is pressed again
		A.toggleWhenPressed(new OUTtaker()); //turns the outake motor on at the same time as the intake motor
		
		LB.whileHeld(new TakeOuter()); // reverses outtake motor
		LB.whileHeld(new ReverseInTaker());// reverse intake motor
	}
	
	public double getForwardAxis() {
		return arcadeStick.getRawAxis(1) * -1.0;//allows the Joystick to command the Robot's forwards and backwards movement
	}
	
	public double getHorizontalAxis(){
		return arcadeStick.getRawAxis(0) * -1.0;//allows the Joystick to command the Robot's side to side movement

	}
	
	public double getTurnAxis(){
		return arcadeStick.getRawAxis(4);//allows the Joystick to command the rotation of the Robot
	}
	public void UpdateSD(){
		Robot.drivetrain.updateSD();//sends all the data from SwerveDrive subsystem to the SmartDashboard
	}
}
