package frc.robot.commands;

import frc.robot.Constants.speedsAndOtherStuff;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class IntakeCommand extends Command {
    private final Timer timer = new Timer();

    private final ShooterSubsystem shooterSubsystem;
    private final double speed;

    public IntakeCommand(ShooterSubsystem subsystem, double shootSpeed) {
        shooterSubsystem = subsystem;
        speed = shootSpeed;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        if (!speedsAndOtherStuff.loaded) {
            shooterSubsystem.driveShooterMotors(speed);
            if (shooterSubsystem.fullyLoadedShooter()) {
                timer.reset();
                timer.start();
                speedsAndOtherStuff.intaking = true;
            }
        }
        
        if (speedsAndOtherStuff.intaking && timer.get() > speedsAndOtherStuff.timeToIntake) {
            speedsAndOtherStuff.loaded = true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.stop();
        speedsAndOtherStuff.loaded = false;
        speedsAndOtherStuff.intaking = false;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}