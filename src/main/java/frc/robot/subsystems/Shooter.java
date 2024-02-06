package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


 public class Shooter extends SubsystemBase{
      private final CANSparkMax m_feeder;
      private final CANSparkMax m_shooter; 
      private double m_voltageShooter;
      private double m_voltageFeeder;

      
      public Shooter() {
        //m_controller = new CANSparkMax(18, MotorType.kBrushed);
        m_feeder = new CANSparkMax(18, MotorType.kBrushed);
        m_shooter = new CANSparkMax(3, MotorType.kBrushed);
        m_voltageShooter = 1;
        m_voltageFeeder = 1;
        m_shooter.set(m_voltageShooter);
        m_feeder.set(m_voltageFeeder);
       
      }


 }
