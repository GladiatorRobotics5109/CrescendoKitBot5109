// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.AutoLine;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Led;
import frc.robot.subsystems.Intake;



import frc.robot.subsystems.DriveTrain;

 
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final Shooter m_shooterSubsystem = new Shooter();

  private final DriveTrain m_driveTrain = new DriveTrain();

  private final Intake m_intake = new Intake();
  // private final Shooter m_feeder = new Shooter();

  private final Led m_led = new Led();


  // Replace with CommandPS4Controller or CommandJoystick if needed
  public  CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,

    

    // drive train binding to the controller

    



    m_driveTrain.setDefaultCommand(
      m_driveTrain.getArcadeDriveWithJoystickCommand(
      () -> m_driverController.getLeftY(),
      () -> m_driverController.getRightX()
      )
    );



    m_led.setDefaultCommand(
      m_led.toggleLed(
      () -> m_driverController.getLeftY()
      )
    );
    

    
    
    // cancelling on release.
    
    m_driverController.leftTrigger().whileTrue(m_shooterSubsystem.startShooter()).whileFalse(m_shooterSubsystem.stopShooter());
    m_driverController.rightTrigger().whileTrue(m_shooterSubsystem.startFeed()).whileFalse(m_shooterSubsystem.stopFeed());
    m_driverController.a().whileTrue(m_shooterSubsystem.toggleShoot());
    m_driverController.x().whileTrue(m_shooterSubsystem.ampShoter());
    m_driverController.y().whileTrue(m_intake.toggleTake());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new SequentialCommandGroup(new AutoLine(m_driveTrain));
  }

  public void teleopPeriodic(){

 
  }
}
