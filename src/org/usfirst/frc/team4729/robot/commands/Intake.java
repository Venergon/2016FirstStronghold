package org.usfirst.frc.team4729.robot.commands;

import org.usfirst.frc.team4729.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake extends Command {
	
	boolean shootTimerOn;
	Timer shootTimer;

    public Intake() {
    	requires(Robot.shooter);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	shootTimer = new Timer();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (shootTimerOn == false) {
    		shootTimerOn = true;
    		shootTimer.start(); 
    	} 
    	
    	Robot.shooter.intake();
    	if (shootTimer.get() <= 5000) {
    		Robot.lED.set(1,0.15,0);
    	}
    	
    	else if (shootTimer.get() <= 10000){
    		Robot.lED.set(0,0,0);
    	}
    	
    	else {
    		shootTimer.reset();
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
    	Robot.shooter.stop();
    	shootTimer.stop();
    	shootTimer.reset();
    	shootTimerOn = false;
    }
}
