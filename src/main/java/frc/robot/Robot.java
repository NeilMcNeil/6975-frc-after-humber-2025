package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
//import frc.robot.commands.MoveCommand;
import frc.robot.subsystems.DriveSubsystem;

public class Robot extends TimedRobot {
  //private Command m_autonomousCommand;
  private final RobotContainer m_robotContainer;
  //public final DriveSubsystem driveSubsystem;


  public Robot() {
    m_robotContainer = new RobotContainer();
    //driveSubsystem = m_robotContainer.driveSubsystem;
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}
  
  //Timer timer = new Timer();
  @Override
  public void autonomousInit() {
    // m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    
    // if (m_autonomousCommand != null) {
    //     m_autonomousCommand.schedule();
    // }

    // timer.start();
    //new MoveCommand(m_robotContainer.driveSubsystem, 20).schedule();
  }

  @Override
  public void autonomousPeriodic() {
    // if(timer.get() < 0.5){
    //   driveSubsystem.drive.arcadeDrive(0.5, 0.0);
    // } else{
    //   driveSubsystem.drive.arcadeDrive(0.0, 0.0);
    // }
  }

  @Override
  public void teleopInit() {
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.cancel();
    // }
    //driveSubsystem.setDefaultCommand(m_robotContainer.getDriveCommand());
    // Command driveCommand = m_robotContainer.getDriveCommand();
    // if (driveCommand != null) {
    //     System.out.println("Setting default drive command...");
    //     driveSubsystem.setDefaultCommand(driveCommand);
    // } else {
    //     System.out.println("ERROR: Drive command is NULL!");
    // }
  }

  @Override
  public void teleopPeriodic() {
    // System.out.println("Current command: " + driveSubsystem.getCurrentCommand());
    // System.out.println("Current speed: " + m_robotContainer.joystick.getX());
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
