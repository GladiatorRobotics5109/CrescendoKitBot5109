// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final class DriveConstants {
    public static final int leftMotorPort = 2;
    public static final int rightMotorPort = 3;
    public static final int leftEncoderChannelA = 0; // Unknown
    public static final int leftEncoderChannelB = 1; // Unknown
    public static final int rightEncoderChannelA = 2; // Unknown
    public static final int rightEncoderChannelB = 3; // Unknown
    public static final double tickToMeterConverter = 1.0 / 4096.0 * 0.128 * Math.PI;
    public static final double autoDriveForwardSpeed = 0.6; // 60% ?
    public static final double autoDriveForwardDistance = 3.1; // Actual Distance: 118.25 inches, 3 meters
}
}
