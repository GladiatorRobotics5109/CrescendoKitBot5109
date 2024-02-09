// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import java.util.function.DoubleSupplier;

import frc.robot.RobotContainer;




public class DriveTrain extends SubsystemBase {

  private final Spark leftMotor;
  private final Spark rightMotor;
  private final DifferentialDrive drive;

  


  /** Creates a new DriveTrain. */
  public DriveTrain() {
    leftMotor = new Spark(2);
    rightMotor = new Spark(3);

    drive = new DifferentialDrive(leftMotor, rightMotor);

    leftMotor.setInverted(true);
  }

  // Arcade drive method
  public Command getArcadeDriveWithJoystickCommand(DoubleSupplier vx, DoubleSupplier vrot) {
    return this.runOnce(
      () -> {
        double throttle = vx.getAsDouble();
        double rotation = vrot.getAsDouble();
        
        arcadeDrive(throttle, rotation);
      }
    );
  }

  public void arcadeDrive(double throttle, double rotation) {
    drive.arcadeDrive(-throttle, rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
