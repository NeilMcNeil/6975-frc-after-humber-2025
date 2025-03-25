package frc.robot.commands;

import frc.robot.Constants.speedsAndOtherStuff;
import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Math;


public class ElevatorCommand extends Command {

    private final ElevatorSubsystem elevatorSubsystem;
    private final double speed;

    public ElevatorCommand(ElevatorSubsystem subsystem) {
        elevatorSubsystem = subsystem;
        speed = speedsAndOtherStuff.elevatorSpeed;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        if (speedsAndOtherStuff.elevatorLevel != -1) {
            double encoderData = elevatorSubsystem.rightElevatorMotor.getEncoder().getPosition() * -1.0;
            double desiredPosition = speedsAndOtherStuff.elevatorPositions.get(speedsAndOtherStuff.elevatorLevel);
            double distToCover = desiredPosition - Math.getAbsOfDouble(encoderData);
            double dir = distToCover < 0.0 ? 1.0 : -1.0;
            double moveSpeed = distToCover < speedsAndOtherStuff.elevatorSlowSpeedTolerance ? speedsAndOtherStuff.elevatorSlowSpeed : speed;
            moveSpeed *= dir;

            if (Math.getAbsOfDouble(distToCover) > speedsAndOtherStuff.elevatorMoveTolerance) {
                elevatorSubsystem.elevatorLowTaperFade(moveSpeed);
            } else {
                elevatorSubsystem.stop();
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
        elevatorSubsystem.stop();
        if (interrupted){speedsAndOtherStuff.elevatorLevel = -1;}
    }

    @Override
        public boolean isFinished() {
        return false;
    }
}