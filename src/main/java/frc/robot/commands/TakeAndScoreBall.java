package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Intake;

public class TakeAndScoreBall extends Command {
    private final Intake intake;
    private final Shooter shooter;
    private final double timeout;
    private double startTime;

    public TakeAndScoreBall(Intake intake, Shooter shooter, double timeout) {
        this.intake = intake;
        this.shooter = shooter;
        this.timeout = timeout;
        addRequirements(intake, shooter);
    }

    @Override
    public void initialize() {
        startTime = Timer.getFPGATimestamp();
        intake.setWantedState(Intake.SystemState.OPEN);
        shooter.startSpin();
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
        intake.setWantedState(Intake.SystemState.CLOSE);
        shooter.stopSpin();
    }

}
