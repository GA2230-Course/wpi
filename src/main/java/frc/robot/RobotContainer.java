// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.SpinShooterWithTimeout;
import frc.robot.commands.TakeAndScoreBall;
import frc.robot.commands.OpenIntakeWithTimeout;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;  

public class RobotContainer {
  private final Shooter shooter = new Shooter();
  private final Intake intake = new Intake();
  private final CommandPS4Controller driverController = new CommandPS4Controller(0);

  public RobotContainer() {
    configureBindings();

  }

  private void configureBindings() {
    driverController.cross().onTrue(new TakeAndScoreBall(intake, shooter, 3.0));  }

  public Command getAutonomousCommand() {
    return new TakeAndScoreBall(intake, shooter, 7.0);
  }
}
