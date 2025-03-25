package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkMax;
import frc.robot.Constants;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

public class ElevatorSubsystem extends SubsystemBase {
    public SparkMax rightElevatorMotor = new SparkMax(Constants.PortsAndIDsAndStuff.rightElevatorID, MotorType.kBrushless);
    public SparkMax leftElevatorMotor = new SparkMax(Constants.PortsAndIDsAndStuff.leftElevatorID, MotorType.kBrushless);
    // elevator motors ig
    SparkMaxConfig rightElevatorConfig = new SparkMaxConfig();
    SparkMaxConfig leftElevatorConfig = new SparkMaxConfig();

    public ElevatorSubsystem() {
        rightElevatorConfig.smartCurrentLimit(40).idleMode(IdleMode.kBrake);
        // left is same as right, just inverted
        leftElevatorConfig.apply(rightElevatorConfig).follow(rightElevatorMotor, true);

        rightElevatorMotor.configure(rightElevatorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftElevatorMotor.configure(leftElevatorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    // this is a really complicated function, and contrary to 
    // popular belief, it actually sets the rightelevatormotor speed to speed
    public void elevatorLowTaperFade(double speed) {
        rightElevatorMotor.set(speed);
    }

    public double T() {
        return rightElevatorMotor.getEncoder().getPosition();
    }

    public void stop() {
        rightElevatorMotor.set(0.0);
    }

    public void changeLevel(int button){
        Constants.speedsAndOtherStuff.elevatorLevel = Constants.speedsAndOtherStuff.buttonToLevel.get(button);
    }
}