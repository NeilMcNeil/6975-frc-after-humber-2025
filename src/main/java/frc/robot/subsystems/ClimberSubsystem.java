package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkMax;
import frc.robot.Constants;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

public class ClimberSubsystem extends SubsystemBase {
    public SparkMax rightClimberMotor = new SparkMax(Constants.PortsAndIDsAndStuff.rightClimberID, MotorType.kBrushless);
    public SparkMax leftClimberMotor = new SparkMax(Constants.PortsAndIDsAndStuff.leftClimberID, MotorType.kBrushless);
    SparkMaxConfig rightClimberConfig = new SparkMaxConfig();
    SparkMaxConfig leftClimberConfig = new SparkMaxConfig();

    public ClimberSubsystem() {
        rightClimberConfig.smartCurrentLimit(50).idleMode(IdleMode.kBrake);
        leftClimberConfig.apply(rightClimberConfig).follow(rightClimberMotor, true);
        rightClimberMotor.configure(rightClimberConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftClimberMotor.configure(leftClimberConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void climb(double speed) {
        rightClimberMotor.set(speed);
    }

    public void stop() {
        rightClimberMotor.set(0.0);
    }
}