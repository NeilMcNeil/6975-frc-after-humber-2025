package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// when we get ultrasonics working
//import edu.wpi.first.wpilibj.Ultrasonic;

public class Auto extends SequentialCommandGroup {
    public Auto(DriveSubsystem driveSubsystem, ElevatorSubsystem elevatorSubsystem, ShooterSubsystem shooterSubsystem) {
        addCommands(
            //new MoveCommand(driveSubsystem, Constants.speedsAndOtherStuff.autoEncoderDistance)  // Drive foreward
            //new InstantCommand(() -> elevatorSubsystem.changeLevel(7)) // Move elevator to l4 or something like that
            //new ShootCommand(shooterSubsystem, Constants.speedsAndOtherStuff.shootSpeed) // Shoot
        );
        addRequirements(driveSubsystem, elevatorSubsystem, shooterSubsystem);
    }
}