package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private boolean isSpining = false;

    public Shooter() {
    }

    @Override
    public void periodic() {
        //System.out.println("is shooter spining:" + isSpining);
    }

    public void startSpin() {
        isSpining = true;
    }

    public void stopSpin() {
        isSpining = false;
    }
}
