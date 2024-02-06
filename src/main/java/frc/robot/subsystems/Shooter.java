 package frc.robot.subsystems;

 import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
 import edu.wpi.first.wpilibj2.command.SubsystemBase;



 public class Shooter extends SubsystemBase{
      private final CANSparkMax m_controller;
      
      public Shooter() {
        m_controller = new CANSparkMax(0, null) 

      }


 }
