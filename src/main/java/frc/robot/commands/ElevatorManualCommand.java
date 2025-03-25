package frc.robot.commands;

import frc.robot.Constants.speedsAndOtherStuff;
import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class ElevatorManualCommand extends Command {

    private final ElevatorSubsystem elevatorSubsystem;
    private final double speed;

    public ElevatorManualCommand(ElevatorSubsystem subsystem, double m_speed) {
        elevatorSubsystem = subsystem;
        speed = m_speed;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        speedsAndOtherStuff.elevatorLevel = -1;
    }

    @Override
    public void execute() {
        elevatorSubsystem.elevatorLowTaperFade(speed);
        // System.out.println(elevatorSubsystem);
        // System.out.println(elevatorSubsystem.T());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        elevatorSubsystem.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        // my people need me, and I must go
        speedsAndOtherStuff.elevatorLevel = -1;
        return false;
    }
}