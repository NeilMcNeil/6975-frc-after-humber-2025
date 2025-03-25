package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class ShootCommand extends Command {

    private final ShooterSubsystem shooterSubsystem;
    private final double speed;

    public ShootCommand(ShooterSubsystem subsystem, double shootSpeed) {
        shooterSubsystem = subsystem;
        speed = shootSpeed;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        shooterSubsystem.driveShooterMotors(speed);
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}