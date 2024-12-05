package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Intake {

//hardware
static TalonSRX IntakeLeft;
static TalonSRX IntakeRight;

double OFF;
//Constructor
public Intake() {
    IntakeLeft = new TalonSRX(8);
    IntakeRight = new TalonSRX(7);
}

public void stop(){
    OFF = 0;

    IntakeLeft.set(ControlMode.PercentOutput,OFF);
    IntakeRight.set(ControlMode.PercentOutput,OFF);
}

public void comer(double left_trigger_axis, double right_trigger_axis){
    if (left_trigger_axis > 0) {
    IntakeLeft.set(ControlMode.PercentOutput,-left_trigger_axis); //negativo para que coma si no irian igual los motores
    IntakeRight.set(ControlMode.PercentOutput,left_trigger_axis);
        }
    else if (right_trigger_axis > 0){
    IntakeLeft.set(ControlMode.PercentOutput,left_trigger_axis); //negativo para que coma si no irian igual los motores
    IntakeRight.set(ControlMode.PercentOutput,-left_trigger_axis);        
        }
    }

}
