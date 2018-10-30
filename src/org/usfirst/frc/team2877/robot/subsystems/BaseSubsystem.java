package org.usfirst.frc.team2877.robot.subsystems;

import org.usfirst.frc.team2877.robot.Robot;
import org.usfirst.frc.team2877.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BaseSubsystem extends Subsystem {
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon motor;
	AnalogInput pot;
	
	PIDController turretController;
	private double P = 0.1;
	private double I = 0.001;
	private double D = 0.0;
	
	private final double minTurnAngle = RobotMap.TURN_ANGLE_BUFFER;
	private final double maxTurnAngle = 360 - RobotMap.TURN_ANGLE_BUFFER;
	
	private double targetAngle = 0.0;
	
	public BaseSubsystem() {
		motor = new CANTalon(RobotMap.CT_BASE);
		
		pot = new AnalogInput(RobotMap.POTENTIOMETER_ID);	//or, use AnalogPotentiometer to pre-scale potentiometer values to 360 degrees
		
		turretController = new PIDController(P, I, D, pot, motor);
		turretController.enable();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void turnBaseTelep() {
    	turretController.setSetpoint( (Robot.oi.getRJoystickX() + 1) * 2.5 );	//map controller input to voltage range
    }
    
    public void turnBaseAutonomous() {
    	turretController.setSetpoint( (double)(targetAngle / 72) );	//map target angle to target voltage
    }
    
    public void setTargetAngle(double angle) {		//implement this instead of joystick for autonomous
    	if (angle >= minTurnAngle && angle <= maxTurnAngle) {	//ensures not turning turret too far in either direction
    		targetAngle = angle; return;	//shifts the zero degrees from the potentiometer
    	}
    	System.out.println("ERROR: cannot turn base to " + angle +
    			" degrees (must be between" + minTurnAngle + " and " + maxTurnAngle + ")");
    }
    
    public void enablePID() {
    	turretController.enable();
    }
    
    public void disablePID() {
    	turretController.disable();
    }
    
    public double getTurretPosition() {
    	return pot.getVoltage() * 72;	//scale voltage to degrees
    }
    
    public double getTargetAngle() {
    	return targetAngle;
    }
    
    public boolean isOnTarget() {	//only use for autonomous, as teleop does not have an official target angle
    	return getTurretPosition() == targetAngle;	//TODO: round this to a certain decimal to be able to be comparable
    }
}
