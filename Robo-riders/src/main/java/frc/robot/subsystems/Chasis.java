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
        Motor1mDrive1Right1 = new TalonSRX(3);
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
        if(yInput < 0){
            rightspeed = yInput+xInput;
            leftspeed = yInput-xInput;
        }
        else {
            rightspeed = yInput-xInput;
            leftspeed = yInput+xInput;
        }
        realLeftSpeed=leftspeed;
        realRightSpeed=rightspeed;

        Motor1mDrive1Right1.set(ControlMode.PercentOutput,realRightSpeed);
        Motor1mDrive1Right2.set(ControlMode.PercentOutput,realRightSpeed);
        Motor1mDriveLeft1.set(ControlMode.PercentOutput,realLeftSpeed);  
        Motor1mDriveLeft2.set(ControlMode.PercentOutput,realLeftSpeed);
    }
    public void driveAutonomous() {
        // Define velocidades predefinidas para el modo autónomo
        double predefRightSpeed = 0.5; // Velocidad para los motores derechos
        double predefLeftSpeed = 0.5;  // Velocidad para los motores izquierdos
    
        // Asigna las velocidades a las variables reales
        realLeftSpeed = predefLeftSpeed;
        realRightSpeed = predefRightSpeed;
    
        // Establece las velocidades de los motores
        Motor1mDrive1Right1.set(ControlMode.PercentOutput, realRightSpeed);
        Motor1mDrive1Right2.set(ControlMode.PercentOutput, realRightSpeed);
        Motor1mDriveLeft1.set(ControlMode.PercentOutput, realLeftSpeed);  
        Motor1mDriveLeft2.set(ControlMode.PercentOutput, realLeftSpeed);
    }
    


}