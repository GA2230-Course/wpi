package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Shooter;

public class SpinShooterWithTimeout extends Command {
    private final Shooter shooter;
    private final double timeout;
    private double startTime;

    public SpinShooterWithTimeout(Shooter shooter, double timeout) {
        this.shooter = shooter;
        this.timeout = timeout;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.startSpin();
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
        shooter.stopSpin();
    }
}
