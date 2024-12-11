package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;


public class Intake {

//hardware
//static TalonSRX IntakeLeft;
static TalonSRX IntakeRight;
static CANSparkMax IntakeLeft2;

double OFF;
//Constructor
public Intake() {
    //IntakeLeft = new TalonSRX(8);
    IntakeRight = new TalonSRX(7);
    IntakeLeft2 = new CANSparkMax(6, MotorType.kBrushless);

}

public void stop(){
    OFF = 0;

    //IntakeLeft.set(ControlMode.PercentOutput,OFF);
    IntakeRight.set(ControlMode.PercentOutput,OFF);
    IntakeLeft2.set(OFF);
}

public void comer(double left_trigger_axis, double right_trigger_axis){

double velocidadDEF = 0.5;

    if (left_trigger_axis > 0) {
    //IntakeLeft.set(ControlMode.PercentOutput,velocidadDEF); //negativo para que coma si no irian igual los motores
    IntakeRight.set(ControlMode.PercentOutput,-velocidadDEF);
    IntakeLeft2.set(-velocidadDEF);

        }
    else if (right_trigger_axis > 0){
    IntakeLeft2.set(0.25);
    //IntakeLeft.set(ControlMode.PercentOutput,-velocidadDEF); //negativo para que coma si no irian igual los motores
    IntakeRight.set(ControlMode.PercentOutput,velocidadDEF);  

        }

    else {
    OFF = 0;

    //IntakeLeft.set(ControlMode.PercentOutput,OFF);
    IntakeRight.set(ControlMode.PercentOutput,OFF);
    IntakeLeft2.set(OFF);
    }
    }

public void comer_autonomo(){

    IntakeLeft2.set(-0.4);
    //IntakeLeft.set(ControlMode.PercentOutput,0.3); //negativo para que coma si no irian igual los motores
    IntakeRight.set(ControlMode.PercentOutput,-0.4);

}
 
}
