package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Math;
import frc.robot.Constants.PortsAndIDsAndStuff;
import frc.robot.Constants.speedsAndOtherStuff;

public class DriveSubsystem extends SubsystemBase {
    // Define CANSparkMax motor controllers
    SparkMax leftLeader = new SparkMax(PortsAndIDsAndStuff.frontLeftID, MotorType.kBrushless);
    SparkMax leftFollower = new SparkMax(PortsAndIDsAndStuff.backLeftID, MotorType.kBrushless);
    SparkMax rightLeader = new SparkMax(PortsAndIDsAndStuff.frontRightID, MotorType.kBrushless);
    SparkMax rightFollower = new SparkMax(PortsAndIDsAndStuff.backRightID, MotorType.kBrushless);

    // drive code that makes robot move and stuff and things
    SparkMaxConfig globalConfig = new SparkMaxConfig();
    SparkMaxConfig rightLeaderConfig = new SparkMaxConfig();
    SparkMaxConfig leftFollowerConfig = new SparkMaxConfig();
    SparkMaxConfig rightFollowerConfig = new SparkMaxConfig();

    //ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    // Create Differential Drive
    public final DifferentialDrive drive = new DifferentialDrive(leftLeader, rightLeader);

    public DriveSubsystem() {
        // drive code that makes robot move and stuff and things
        globalConfig
            .smartCurrentLimit(50)
            .idleMode(IdleMode.kBrake);

        //Apply the global config and invert since it is on the opposite side
        rightLeaderConfig
            .apply(globalConfig)
            .inverted(true);

        leftFollowerConfig
            .apply(globalConfig)
            .follow(leftLeader);

        rightFollowerConfig
            .apply(globalConfig)
            .follow(rightLeader);

        // make the motors do what the control groups tell them to do
        leftLeader.configure(globalConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftFollower.configure(leftFollowerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightLeader.configure(rightLeaderConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightFollower.configure(rightFollowerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    // Tank drive method
    public void tankDrive(double xSpeed, double zRotation) {
        System.out.println(xSpeed);
        drive.arcadeDrive(xSpeed, zRotation);
    }

    // Stop in the name of the law, and in the name of command based programs!
    public void stop() {
        drive.arcadeDrive(0, 0);
    }

    // this makes it go straight forward
    public void move(double speed, double encoderMoveAmount) {
        //double rotation = gyro.getAngle();
        //System.out.println("moving");
        //double turnspeed = Math.getAbsOfDouble(rotation) > speedsAndOtherStuff.gyroTolerance ? speedsAndOtherStuff.gyroTurnSpeed : 0.0;
        drive.arcadeDrive(0.5, 0.0);
    }

    public void turn(double speed, double turnAmount) {
        //double angle = gyro.getAngle();
        //double direction = angle < 0.0 ? -1.0 : 1.0;
        // if (Math.getAbsOfDouble(angle) > speedsAndOtherStuff.autoTurnTolerance){
        //     drive.arcadeDrive(0.0, direction*speed);
        // }
    }

    public double encoderCount() {
        return rightLeader.getEncoder().getPosition();
    }

    public void resetEncoders() {
        rightLeader.getEncoder().setPosition(0);
    }

    // public void calibrateGyro() {
    //     gyro.calibrate();
    //     gyro.reset();
    // }
}