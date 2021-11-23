// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

// === C O N T R O L L E R S === //
    public static final int DriveControllerPort = 0;

// === D R I V E - M O T O R S === //
    public static Spark leftBack = new Spark(0);
    public static Spark leftFront = new Spark(1);
    public static Spark rightBack = new Spark(2);
    public static Spark rightFront = new Spark(3);

// === A U X - M O T O R S === //
    public static Spark spoolMotor = new Spark(4);
    public static Spark leftCollector = new Spark(5);
    public static Spark rightCollector = new Spark(6);
    public static Spark leftShooter = new Spark(7);
    public static Spark rightShooter = new Spark(8);

    //TODO tune solenoid on pheonix tuner to the correct number
    public static Solenoid collectorPiston = new Solenoid(41, 4);

// === X B O X - C H A N N E L S === //
  // A X E S
  public static final int leftXAxisChannel = 0;
  public static final int leftYAxisChannel = 1;
  public static final int leftTriggerChannel = 2;
  public static final int rightTriggerChannel = 3;
  public static final int rightXAxisChannel = 4;
  public static final int rightYAxisChannel = 5;

  // B U T T O N S
  public static final int aButtonChannel = 1;
  public static final int bButtonChannel = 2;
  public static final int xButtonChannel = 3;
  public static final int yButtonChannel = 4;

  public static final int leftBumperChannel = 5;
  public static final int rightBumperChannel = 6;

  public static final int backButtonChannel = 7;
  public static final int startButtonChannel = 8;

  public static final int POVU = 0;
  public static final int POVR = 90;
  public static final int POVD = 180;
  public static final int POVL = 270;
}
