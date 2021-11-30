// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// === T O - D O === //

/*TODO tune/add pneumatic command to extend/retract piston,
test
  Shoot
  Collect
  Spool
  Drive
auton (if time)
slack message to Tate about what Programming has been doing in the season
*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoTime;
import frc.robot.commands.VroomVroom;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drive drive = new Drive();
  private final Collector collector = new Collector();
  private final Shooter shooter = new Shooter();

  //private final ExampleCommand m_autoCommand = new ExampleCommand(drive);
  public final static XboxController m_driveController = new XboxController(Constants.DriveControllerPort);
  public final static XboxController m_techController = new XboxController(Constants.TechControllerPort);
  private final JoystickButton collect = new JoystickButton(m_techController, Constants.yButtonChannel);
  private final JoystickButton spoolUp = new JoystickButton(m_techController, Constants.aButtonChannel);
  private final JoystickButton spoolDown = new JoystickButton(m_techController, Constants.xButtonChannel);
  private final JoystickButton shoot = new JoystickButton(m_techController, Constants.rightTriggerChannel);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    drive.setDefaultCommand(
        // // A split-stick arcade command, with forward/backward controlled by the left
        // // hand, and turning controlled by the right.
        new VroomVroom(drive, () -> -m_driveController.getY(GenericHID.Hand.kLeft),
            () -> m_driveController.getX(GenericHID.Hand.kRight)));

           
  }
// === C O M M A N D S === //
  StartEndCommand collectRun = new StartEndCommand(
      () -> collector.collect(1),
      () -> collector.collect(0),
      collector
      );
  StartEndCommand spoolUpRun = new StartEndCommand(
      () -> collector.spool(1),
      () -> collector.spool(0),
      collector
      );      
  StartEndCommand spoolDownRun = new StartEndCommand(
      () -> collector.spool(-1),
      () -> collector.spool(0),
      collector
      );
  StartEndCommand shooterRun = new StartEndCommand(
      () -> shooter.shoot(1.0, 1.0),
      () -> shooter.shoot(0.0, 0.0),
      shooter
      );        
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    collect.whileHeld(collectRun);
    spoolUp.whileHeld(spoolUpRun);
    spoolDown.whileHeld(spoolDownRun);
    shoot.whileHeld(shooterRun);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new AutoTime(drive);
  }
}
