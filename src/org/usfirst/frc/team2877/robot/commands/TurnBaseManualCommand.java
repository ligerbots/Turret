package org.usfirst.frc.team2877.robot.commands;

import org.usfirst.frc.team2877.robot.Robot;
import org.usfirst.frc.team2877.robot.subsystems.BaseSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnBaseManualCommand extends Command {
	private BaseSubsystem tBase = new BaseSubsystem();
	
    public TurnBaseManualCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.turretBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	tBase.turnBaseTelep();
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
