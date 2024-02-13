// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import java.util.function.DoubleSupplier;


public class Led extends SubsystemBase {
  private final AddressableLED m_Led;
  private final AddressableLEDBuffer m_ledBuffer;
  private boolean LedStatus;

  /** Creates a new Led. */
  public Led() {

    m_Led  = new AddressableLED(4);

    m_ledBuffer = new AddressableLEDBuffer(60);
    m_Led.setLength(m_ledBuffer.getLength());

    m_Led.setData(m_ledBuffer);
    m_Led.start();



  }

  //lets get some lit leds boys
  public Command toggleLed(DoubleSupplier val){

    return this.runOnce(() -> {

      Double ledStat = val.getAsDouble();

      if (ledStat != 0) {

        GlowLed(255, 255, 255);
        
      } else{
        GlowLed(0, 0, 0);
      }



    });

    

  }

  //this leds bout to crazy 

  public void GlowLed(int R, int G, int B){

    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      // Sets the specified LED to the HSV values for red
      m_ledBuffer.setRGB(i, R, G, B);
    }
   
    m_Led.setData(m_ledBuffer);

  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
