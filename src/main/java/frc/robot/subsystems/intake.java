package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private final Talon m_BottomIntake;
    private final CANSparkMax m_TopIntake;
    private double m_voltageIntake;
    boolean take;


    public Intake(){
        m_BottomIntake = new Talon(8);
        m_TopIntake = new CANSparkMax(14, MotorType.kBrushless);
        m_voltageIntake = 0;
        m_BottomIntake.set(m_voltageIntake);
        m_TopIntake.set(m_voltageIntake);
    }
    //public Command startIntake(){
     //   return this.runOnce(() -> {
       //     m_BottomIntake.set(1);
         //   System.out.println("balls");
          //});
    //}
    //public Command stopIntake(){
      //  return this.runOnce(() -> {
        //    m_BottomIntake.set(0);
          //  System.out.println("balls 2.0 ");
          //});
    //}
    public Command toggleTake() {
        return this.runOnce(() -> {if (take == false){
          m_BottomIntake.set(1);
          m_TopIntake.set(1);
          take = true; 
        }else{
          m_BottomIntake.set(0);
          m_TopIntake.set(0);
          take = false;
        }
        });
      }
}