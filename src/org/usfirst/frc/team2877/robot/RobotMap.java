package org.usfirst.frc.team2877.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static final int CT_BASE = 1;
	public static final double TURN_ANGLE_BUFFER = 30.0;	//degrees- CAREFUL: make sure to leave buffer zone so don't break potentiometer
	
	public static final int POTENTIOMETER_ID = 4;
	
	public static final int CT_R_SHOOTER_MASTER = 2;	//TODO: change pins
	public static final int CT_L_SHOOTER_SLAVE = 3;
	
	public static final int SHOOTER_FIN_ID = 5;
}
