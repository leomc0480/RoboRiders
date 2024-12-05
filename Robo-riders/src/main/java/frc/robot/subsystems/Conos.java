package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;


public class Conos {

    static CANSparkMax ruedas;
    static CANSparkMax angulo;
    
    //Constructor
    public Conos(){
    ruedas = new CANSparkMax(8, MotorType.kBrushless);
    angulo = new CANSparkMax(5,MotorType.kBrushless);
    }

    public void comer(double right_trigger_axis, double left_trigger_axis){

        if (left_trigger_axis > 0){ //comer
            ruedas.set(left_trigger_axis);
        }
        else if (right_trigger_axis > 0){ //escupir
            ruedas.set(-left_trigger_axis);
        }
    }

    public void mover(double right_yJoyStick_Axis){

        if (right_yJoyStick_Axis > 0){ //arriba
            angulo.set(0.5);
        }

        else if (right_yJoyStick_Axis < 0){ //abajo
            angulo.set(-0.5);            
        }
    }

    public void stop(){
        ruedas.set(0);
        angulo.set(0);
    }
}
