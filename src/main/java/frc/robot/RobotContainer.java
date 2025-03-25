// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ElevatorCommand;
import frc.robot.commands.ElevatorManualCommand;
import frc.robot.commands.ClimbCommand;
//import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShootCommand;
// import frc.robot.commands.Auto;
// import frc.robot.commands.MoveCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ClimberSubsystem climbSubsystem = new ClimberSubsystem();


  private final ElevatorCommand defaultElevatorCommand = new ElevatorCommand(elevatorSubsystem);

  public final Joystick joystick = new Joystick(Constants.PortsAndIDsAndStuff.joystickPort);
  //private final GenericHID wackyController = new GenericHID(Constants.PortsAndIDsAndStuff.controllerPort);

  // ken got a 60 in gym

  public RobotContainer() {
    driveSubsystem.setDefaultCommand(
      new RunCommand(
          () -> driveSubsystem.tankDrive(
            -joystick.getY()*Constants.speedsAndOtherStuff.moveSpeed, // move forward speed zoom zoom
            -joystick.getX()*Constants.speedsAndOtherStuff.moveSpeed // rotation control
          ),
          driveSubsystem
      )
    );

    elevatorSubsystem.setDefaultCommand(defaultElevatorCommand);
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(joystick, 11)
        .whileTrue(new ElevatorManualCommand(elevatorSubsystem, Constants.speedsAndOtherStuff.elevatorSpeed))
        .onFalse(new InstantCommand(elevatorSubsystem::stop));

    new JoystickButton(joystick, 12)
        .whileTrue(new ElevatorManualCommand(elevatorSubsystem, -Constants.speedsAndOtherStuff.elevatorSpeed))
        .onFalse(new InstantCommand(elevatorSubsystem::stop));

    new JoystickButton(joystick, Constants.PortsAndIDsAndStuff.climbDownButton)
        .whileTrue(new ClimbCommand(climbSubsystem, Constants.speedsAndOtherStuff.climbSpeed))
        .onFalse(new InstantCommand(climbSubsystem::stop));

    new JoystickButton(joystick, Constants.PortsAndIDsAndStuff.climbUpButton)
        .whileTrue(new ClimbCommand(climbSubsystem, -Constants.speedsAndOtherStuff.climbSpeed))
        .onFalse(new InstantCommand(climbSubsystem::stop));

    new JoystickButton(joystick, 7)
        .onTrue(new InstantCommand(() -> elevatorSubsystem.changeLevel(7)));

    new JoystickButton(joystick, 8)
        .onTrue(new InstantCommand(() -> elevatorSubsystem.changeLevel(8)));

    new JoystickButton(joystick, 9)
        .onTrue(new InstantCommand(() -> elevatorSubsystem.changeLevel(9)));

    new JoystickButton(joystick, 10)
        .onTrue(new InstantCommand(() -> elevatorSubsystem.changeLevel(10)));

    new JoystickButton(joystick, 1).whileTrue(new ShootCommand(shooterSubsystem, Constants.speedsAndOtherStuff.shootSpeed));

    
    // new JoystickButton(wackyController, Constants.PortsAndIDsAndStuff.rb)
    //     .whileTrue(new ShootCommand(shooterSubsystem, Constants.speedsAndOtherStuff.shootSpeed));

    // new JoystickButton(wackyController, Constants.PortsAndIDsAndStuff.a)
    //     .onTrue(new InstantCommand(() -> elevatorSubsystem.changeLevel(7)));

    // new JoystickButton(wackyController, Constants.PortsAndIDsAndStuff.x)
    //     .onTrue(new InstantCommand(() -> elevatorSubsystem.changeLevel(8)));

    // new JoystickButton(wackyController, Constants.PortsAndIDsAndStuff.b)
    //     .onTrue(new InstantCommand(() -> elevatorSubsystem.changeLevel(9)));

    // new JoystickButton(wackyController, Constants.PortsAndIDsAndStuff.y)
    //     .onTrue(new InstantCommand(() -> elevatorSubsystem.changeLevel(10)));

    // new JoystickButton(wackyController, Constants.PortsAndIDsAndStuff.back)
    //     .whileTrue(new ElevatorManualCommand(elevatorSubsystem, Constants.speedsAndOtherStuff.elevatorSpeed))
    //     .onFalse(new InstantCommand(elevatorSubsystem::stop));

    // new JoystickButton(wackyController, Constants.PortsAndIDsAndStuff.start)
    //     .whileTrue(new ElevatorManualCommand(elevatorSubsystem, -Constants.speedsAndOtherStuff.elevatorSpeed))
    //     .onFalse(new InstantCommand(elevatorSubsystem::stop));
    //new JoystickButton(joystick, 1).whileTrue(new IntakeCommand(shooterSubsystem, Constants.speedsAndOtherStuff.intakeSpeed));
  }

  // public Command getAutonomousCommand() {
  //   return new Auto(driveSubsystem, elevatorSubsystem, shooterSubsystem);
  // }

  // public Command getDriveCommand() {
  //   return new RunCommand(
  //     () -> driveSubsystem.tankDrive(
  //       -joystick.getY()*Constants.speedsAndOtherStuff.moveSpeed, // move forward speed zoom zoom
  //       -joystick.getX()*Constants.speedsAndOtherStuff.moveSpeed // rotation control
  //     ), driveSubsystem);
  // }
}
