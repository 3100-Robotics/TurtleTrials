// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Drive extends SubsystemBase {

  
  SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftBack, leftFront);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightBack, rightFront);

  DifferentialDrive m_drive = new DifferentialDrive(leftMotors, rightMotors);

  
  public Drive() {}


  public void arcadeDrive(double left, double right){

    m_drive.arcadeDrive(left, right);

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
