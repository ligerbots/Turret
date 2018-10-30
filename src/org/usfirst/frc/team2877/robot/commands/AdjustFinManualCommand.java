package org.usfirst.frc.team2877.robot.commands;

import org.usfirst.frc.team2877.robot.Robot;
import org.usfirst.frc.team2877.robot.subsystems.ShooterFinSubsystem;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AdjustFinManualCommand extends Command {
	ShooterFinSubsystem sFin;
	private final GenericHID.Hand triggerID;
	
	//don't want these properties to change when creating new instances of commands as buttons are pressed
	static private double angle = 0.0;
	static private final double angleAdjustUnit = 1.0;	//determines how much servo will turn per execution (angle)
	static private final double minAngle = 0.0;
	static private final double maxAngle = 360.0;
	
    public AdjustFinManualCommand(GenericHID.Hand triggerID) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.fin);
    	
    	sFin = new ShooterFinSubsystem();
    	this.triggerID = triggerID;
    	//triggerID ? GenericHID.Hand.kRight: GenericHID.Hand.kLeft;	//true means right bumper
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//sFin.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	final double adjusted = (triggerID == GenericHID.Hand.kRight ? AdjustFinManualCommand.angleAdjustUnit : -AdjustFinManualCommand.angleAdjustUnit) + AdjustFinManualCommand.angle;	//change signs so bumper id indicated direction
    	if (adjusted > AdjustFinManualCommand.minAngle && adjusted < AdjustFinManualCommand.maxAngle) {	//make sure not to move beyond limitations
    		sFin.setFinPosition( adjusted );
    		angle = sFin.getPosition();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
