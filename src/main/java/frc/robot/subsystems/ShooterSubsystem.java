package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkMax;
import frc.robot.Constants;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

public class ShooterSubsystem extends SubsystemBase {
    SparkMax rightShooter550Motor = new SparkMax(Constants.PortsAndIDsAndStuff.right550ID, MotorType.kBrushless);
    SparkMax leftShooter550Motor = new SparkMax(Constants.PortsAndIDsAndStuff.left550ID, MotorType.kBrushless);
    SparkMaxConfig rightShooterConfig = new SparkMaxConfig();
    SparkMaxConfig leftShooterConfig = new SparkMaxConfig();

    public ShooterSubsystem() {
        rightShooterConfig.smartCurrentLimit(20).idleMode(IdleMode.kBrake);
        leftShooterConfig.apply(rightShooterConfig).follow(rightShooter550Motor, true);

        rightShooter550Motor.configure(rightShooterConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftShooter550Motor.configure(leftShooterConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void driveShooterMotors(double speed) {
        rightShooter550Motor.set(speed);
    }

    public boolean fullyLoadedShooter() {
        double speed = leftShooter550Motor.getEncoder().getVelocity();
        boolean loaded = speed > Constants.speedsAndOtherStuff.shootCurrentWhenIntaking ? true : false;
        return loaded;
    }

    public void stop() {
        rightShooter550Motor.set(0.0);
    }
}