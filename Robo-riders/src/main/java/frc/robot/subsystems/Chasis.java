package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Chasis {
    //Hardware
    static TalonSRX Motor1mDriveLeft1;
    static TalonSRX Motor1mDriveLeft2;
    static TalonSRX Motor1mDrive1Right1;
    static TalonSRX Motor1mDrive1Right2;
    //logica
    double speed;

    double leftspeed;
    double rightspeed;

    double realLeftSpeed;
    double realRightSpeed;

    //constructor
    public Chasis(){
        Motor1mDriveLeft1 = new TalonSRX(1);
        Motor1mDriveLeft2 = new TalonSRX(2);
        Motor1mDrive1Right1 = new TalonSRX(3);//esto es lo que cambir este estaba en 4 y el de abajo en 3
        Motor1mDrive1Right2 = new TalonSRX(4);
        

        speed = 0;
        realLeftSpeed =0;
        realRightSpeed =0;
    }
    //funciones
    public void stop(){
        speed = 0;
        Motor1mDrive1Right1.set(ControlMode.PercentOutput,speed);
        Motor1mDrive1Right2.set(ControlMode.PercentOutput,speed);
        Motor1mDriveLeft1.set(ControlMode.PercentOutput,speed);
        Motor1mDriveLeft2.set(ControlMode.PercentOutput,speed);
    }   
    public void drive(double xInput , double yInput){
        //yInput es el nuevo xInput y vicebersa.
        if(yInput > 0){
            rightspeed = yInput-xInput;
            leftspeed = yInput+xInput;
        }
        else {
            rightspeed = yInput+xInput;
            leftspeed = yInput-xInput;
        }
        realLeftSpeed=-leftspeed;
        realRightSpeed=rightspeed; // si no cambia este

        Motor1mDrive1Right1.set(ControlMode.PercentOutput,realRightSpeed);
        Motor1mDrive1Right2.set(ControlMode.PercentOutput,realRightSpeed);
        Motor1mDriveLeft1.set(ControlMode.PercentOutput,realLeftSpeed);  
        Motor1mDriveLeft2.set(ControlMode.PercentOutput,realLeftSpeed);
    }
    public void driveAutonomous() {
//mi teoria es que estan al revez la derecha 
//es la izquierda y la izquierda es la derecha.
//Igual que con el control.
        Motor1mDrive1Right1.set(ControlMode.PercentOutput, -0.6);
        Motor1mDrive1Right2.set(ControlMode.PercentOutput, -0.6);
        Motor1mDriveLeft1.set(ControlMode.PercentOutput, 0.5);  
        Motor1mDriveLeft2.set(ControlMode.PercentOutput, 0.5);
    }
    public void driveAutonomous_Backwards(){
        Motor1mDrive1Right1.set(ControlMode.PercentOutput, 0.5);
        Motor1mDrive1Right2.set(ControlMode.PercentOutput, 0.5);
        Motor1mDriveLeft1.set(ControlMode.PercentOutput, -0.4);  
        Motor1mDriveLeft2.set(ControlMode.PercentOutput, -0.4);
    }
    


}