package org.usfirst.frc.team2877.robot.commands;

import org.usfirst.frc.team2877.robot.Robot;
import org.usfirst.frc.team2877.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterCommand extends Command {
	private ShooterSubsystem shooter;
	
    public ShooterCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	
    	shooter = new ShooterSubsystem();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	shooter.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shooter.shoot();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	shooter.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	shooter.stop();
    }
}
