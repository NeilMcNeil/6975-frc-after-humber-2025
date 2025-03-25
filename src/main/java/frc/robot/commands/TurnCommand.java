// package frc.robot.commands;

// import frc.robot.Constants;
// //import frc.robot.Constants.speedsAndOtherStuff;
// import frc.robot.subsystems.DriveSubsystem;
// import edu.wpi.first.wpilibj2.command.Command;

// public class TurnCommand extends Command {

//     private final DriveSubsystem driveSubsystem;
//     //in degrees
//     private final double turnAmount;

//     public TurnCommand(DriveSubsystem subsystem, double turnDegrees) {
//         driveSubsystem = subsystem;
//         turnAmount = turnDegrees;
//         addRequirements(subsystem);
//     }

//     @Override
//     public void initialize() {
//         driveSubsystem.calibrateGyro();
//         driveSubsystem.resetEncoders();
//     }

//     @Override
//     public void execute() {
//         driveSubsystem.turn(Constants.speedsAndOtherStuff.autoTurnSpeed, turnAmount);
//     }

//     @Override
//     public void end(boolean interrupted) {
//         driveSubsystem.stop();
//     }

//     @Override
//     public boolean isFinished() {
//         boolean finished = driveSubsystem.encoderCount() >=  turnAmount ? true : false;
//         return finished;
//     }
// }