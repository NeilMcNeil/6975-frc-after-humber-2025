package frc.robot.commands;

//import frc.robot.Constants.speedsAndOtherStuff;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class ClimbCommand extends Command {

    private final ClimberSubsystem climberSubsystem;
    private final double speed;

    public ClimbCommand(ClimberSubsystem subsystem, double m_speed) {
        climberSubsystem = subsystem;
        speed = m_speed;
        //System.out.println(speed);
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        //System.out.println(speed);
        climberSubsystem.climb(speed);
    }

    @Override
    public void end(boolean interrupted) {
        climberSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}