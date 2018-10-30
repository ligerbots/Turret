package org.usfirst.frc.team2877.robot.subsystems;

import org.usfirst.frc.team2877.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterFinSubsystem extends Subsystem {
	Servo servo;
	final int defaultAngle = 0;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ShooterFinSubsystem() {
		servo = new Servo(RobotMap.SHOOTER_FIN_ID);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setFinPosition(double d) {
    	servo.setAngle(d);
    }
    
    public void reset() {
    	servo.setAngle(defaultAngle);
    }
    
    public double getPosition() {
    	return servo.getAngle();
    }
}

