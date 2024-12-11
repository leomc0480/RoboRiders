package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;


public class Conos {

    static CANSparkMax ruedas;
    static CANSparkMax angulo;
    
    //Constructor
    public Conos(){
    ruedas = new CANSparkMax(5, MotorType.kBrushless);
    angulo = new CANSparkMax(10,MotorType.kBrushless);
    }

    public void comer(double right_trigger_axis, double left_trigger_axis){

        if (left_trigger_axis > 0){ //comer
            ruedas.set(0.1);
        }
        else if (right_trigger_axis > 0){ //escupir
            ruedas.set(-0.1);
        }

        else  {
            ruedas.set(0);
        }
    }

    public void mover(double right_yJoyStick_Axis){

        if (right_yJoyStick_Axis > 0){ //arriba
            angulo.set(0.9);
        }

        else if (right_yJoyStick_Axis < 0){ //abajo
            angulo.set(-0.9);            
        }
        else {
            angulo.set(0);                        
        }
    }

    public void stop(){
        ruedas.set(0);
        angulo.set(0);
    }
}
