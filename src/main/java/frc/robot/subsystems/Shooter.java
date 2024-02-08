package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

 public class Shooter extends SubsystemBase{
      private final CANSparkMax m_feeder;
      private final CANSparkMax m_shooter;
      private double m_voltageShooter;
      private double m_voltageFeeder;
      boolean shoot;
      
      public Shooter() {
        //m_controller = new CANSparkMax(18, MotorType.kBrushed);
        m_feeder = new CANSparkMax(18, MotorType.kBrushed);
        m_shooter = new CANSparkMax(3, MotorType.kBrushed);
        m_voltageShooter = 0;
        m_voltageFeeder = 0;
        m_shooter.set(m_voltageShooter);
        m_feeder.set(m_voltageFeeder);
       
      }
      public Command startShooter() {
        return this.runOnce(() -> {
          m_feeder.set(1);
        });
      }
      public Command startFeed() {
        return this.runOnce(() -> {
          m_feeder.set(-1);
          m_shooter.set(-1);
        });
      }
      public Command stopShooter() {
        return this.runOnce(() -> { 
          m_feeder.set(0);
        });
      }
      public Command stopFeed() {
        return this.runOnce(() -> {
          m_feeder.set(0); 
          m_shooter.set(0);
        });
      }
      public Command Feed2() {
        shoot = true;
        return this.runOnce(() -> m_feeder.set(1));
      }
      public Command stopFeed2() {
        shoot = false;
        return this.runOnce(() -> m_shooter.set(0));
      }
 }
