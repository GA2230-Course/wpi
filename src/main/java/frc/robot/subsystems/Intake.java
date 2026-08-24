package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private boolean isOpen = false;

    public Intake() {
    }

    @Override
    public void periodic() {
        System.out.println("intake is open: " + isOpen);
    }

    public void openIntake() {
        isOpen = true;
    }

    public void closeIntake() {
        isOpen = false;
    }
}
