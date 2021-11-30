// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoTime extends SequentialCommandGroup {
  /**
   * @param drivetrain The drive subsystem on which this command will run
   */
  public AutoTime(Drive drivetrain) {
    addCommands(
        new DriveTime(0.6, 2.0, drivetrain)
        
        );
  }
}
