package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private final Talon m_intake;
    private double m_voltageIntake;
    boolean take;

    public Intake(){
        m_intake = new Talon(8);
        m_voltageIntake = 0;
        m_intake.set(m_voltageIntake);
    }
    //public Command startIntake(){
     //   return this.runOnce(() -> {
       //     m_intake.set(1);
         //   System.out.println("balls");
          //});
    //}
    //public Command stopIntake(){
      //  return this.runOnce(() -> {
        //    m_intake.set(0);
          //  System.out.println("balls 2.0 ");
          //});
    //}
    public Command toggleTake() {
        return this.runOnce(() -> {if (take == false){
          m_intake.set(1);
          take = true; 
        }else{
          m_intake.set(0);
          take = false;
        }
        });
      }
}