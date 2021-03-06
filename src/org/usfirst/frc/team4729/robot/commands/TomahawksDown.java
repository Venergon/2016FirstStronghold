package org.usfirst.frc.team4729.robot.commands;

import org.usfirst.frc.team4729.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TomahawksDown extends Command {

    public TomahawksDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.tomahawk);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.tomahawk.down();
    	//Robot.camServo.camDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Robot.limitSwitch.isUpper()) {
        	Robot.tomahawk.stop();
        	return true;
        }
        
        else {
        	return false;
        } 
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.tomahawk.stop();
    	//Robot.camServo.stop();
    }
}
