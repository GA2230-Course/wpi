package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    public enum SystemState {
        IDLE,
        OPEN,
        CLOSE
    }

    private SystemState wantedState = SystemState.IDLE;
    private SystemState currentState = SystemState.IDLE;

    public Intake() {
    }

    @Override
    public void periodic() {
        currentState = handleStateTransition();

        switch (currentState) {
            case IDLE:

                System.out.println("Intake is IDLE");
                break;

            case OPEN:
                System.out.println("Intake is OPEN");
                break;
            case CLOSE:
                System.out.println("Intake is CLOSE");
                break;
        }
    }

    private SystemState handleStateTransition() {
        return wantedState;
    }

    public void setWantedState(SystemState newState) {
        this.wantedState = newState;
    }
}