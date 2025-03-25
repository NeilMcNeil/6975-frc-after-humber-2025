// package frc.robot.commands;

// import frc.robot.Constants;
// //import frc.robot.Constants.speedsAndOtherStuff;
// import frc.robot.subsystems.DriveSubsystem;
// import edu.wpi.first.wpilibj2.command.Command;

// public class MoveCommand extends Command {

//     private final DriveSubsystem driveSubsystem;
//     //in encoder counts:
//     private final double moveAmount;

//     public MoveCommand(DriveSubsystem subsystem, double encoderMoveAmount) {
//         driveSubsystem = subsystem;
//         moveAmount = encoderMoveAmount;
//         addRequirements(subsystem);
//     }

//     @Override
//     public void initialize() {
//         //driveSubsystem.calibrateGyro();
//         //driveSubsystem.resetEncoders();
//     }

//     @Override
//     public void execute() {
//         System.out.println("called move");
//         driveSubsystem.move(Constants.speedsAndOtherStuff.autoMoveSpeed, moveAmount);
//     }

//     @Override
//     public void end(boolean interrupted) {
//         driveSubsystem.stop();
//     }

//     @Override
//     public boolean isFinished() {
//         return false;
//     }
// }