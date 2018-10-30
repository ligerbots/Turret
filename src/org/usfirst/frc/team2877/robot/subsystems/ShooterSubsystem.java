package org.usfirst.frc.team2877.robot.subsystems;

import org.usfirst.frc.team2877.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
	private CANTalon shooterMaster;
	private CANTalon shooterSlave;
	
	private final double shooterSpeed = 1.0;
	private final double shooterCurve = 1.0;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ShooterSubsystem() {
		shooterMaster = new CANTalon(RobotMap.CT_R_SHOOTER_MASTER);
		shooterSlave = new CANTalon(RobotMap.CT_L_SHOOTER_SLAVE);
		
		//shooterSlave.changeControlMode(TalonControlMode.Follower);
		
		//what does enableBreakMode() and percentVBus do?
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shoot() {
    	shooterMaster.set(shooterSpeed);
    	shooterSlave.set(shooterSpeed * shooterCurve);
    }
    
    //TODO: create function to translate the distance from target to a shooting velocity (shooter speed) and angle of trajectory (fin angle)
    
    public void stop() {
    	shooterMaster.set(0);
    	shooterSlave.set(0);
    }
}

