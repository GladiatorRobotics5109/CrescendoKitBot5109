// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveTrain;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.Timer;

public class AutoLine extends Command {

  private final Spark leftMotor;
  private final Spark rightMotor;
  private final DifferentialDrive drive;
  private final Encoder leftEncoder;
  private final Encoder rightEncoder;
  private final DriveTrain driveTrain;

  //PID
  final double propConstant = 0.1;
  final double intConstant = 0.1;
  final double diffConstant = 0.1;
  final double iLimit = 1;
  double initialPoint = 0;
  double errorSum = 0;
  double lastError = 0;
  double lastTimestamp = 0;

  /** Creates a new AutoLine. */
  public AutoLine(DriveTrain driveTrain) {
    this.driveTrain = driveTrain;
    leftMotor = new Spark(DriveConstants.leftMotorPort);
    rightMotor = new Spark(DriveConstants.rightMotorPort);
    leftEncoder = new Encoder(DriveConstants.leftEncoderChannelA, DriveConstants.leftEncoderChannelB);
    rightEncoder = new Encoder(DriveConstants.rightEncoderChannelA, DriveConstants.rightEncoderChannelB);
    //leftEncoder.reset()
    //rightEncoder.reset()

    drive = new DifferentialDrive(leftMotor, rightMotor);

    leftMotor.setInverted(true);
  }

  @Override
  public void initialize() {
    
  }

  @Override
  public void execute() {
    // PID ?
    // double sensorPosition = leftEncoder.get() * DriveConstants.tickToMeterConverter;
    // double error = initialPoint - sensorPosition;
    // double deltaTime = Timer.getFPGATimestamp() - lastTimestamp;

    // if (Math.abs(error) < iLimit) {//Over
    //   errorSum += error * deltaTime;
    // }
    // double errorRate = (error - lastError) / deltaTime;
    // double outputSpeed = propConstant*error + intConstant*errorSum + diffConstant*errorRate;

    // // Note: Not Inverted
    // leftMotor.set(outputSpeed);
    // rightMotor.set(outputSpeed);
    // lastTimestamp = Timer.getFPGATimestamp();
    // lastError = error;

    driveTrain.autoDrive(DriveConstants.autoDriveForwardSpeed, DriveConstants.autoDriveForwardSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    driveTrain.autoDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    if (driveTrain.getEncoderMeters() > DriveConstants.autoDriveForwardDistance)
      return true;
    else
      return false;
  }
}

// Sim motor
// 
