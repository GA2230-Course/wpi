package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.Timer;
public class OpenIntakeWithTimeout extends Command {
    private final Intake intake;
    private final double timeout;
    private double startTime;
    public OpenIntakeWithTimeout(Intake intake, double timeout) {
        this.intake = intake;
        this.timeout = timeout;
        addRequirements(intake);
    }
    @Override
    public void initialize() {
        intake.openIntake();
        startTime = Timer.getFPGATimestamp();
    }
    @Override
    public void execute() {
    }
    @Override
    public boolean isFinished() {
        return (Timer.getFPGATimestamp() - startTime) >= timeout;
    }
    @Override
    public void end(boolean interrupted) {
        intake.closeIntake();
    }

}
