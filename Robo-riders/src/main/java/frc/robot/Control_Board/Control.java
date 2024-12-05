package frc.robot.Control_Board;

import edu.wpi.first.wpilibj.XboxController;

public class Control{
    //Hardware
    XboxController driver;
    XboxController mecanismos;
    //logica
    double tolerance;
    //Constructor
    public Control(){
        driver = new XboxController(0);
        mecanismos = new XboxController(1);
        tolerance = .15;
    }
    //funcionesq

    //DRIVER--------------------------------------------
    public double left_X_stick_driver(){
        double xLeftValue = driver.getLeftX();
        if(Math.abs(xLeftValue)<tolerance){
            xLeftValue = 0;
        }
        return xLeftValue;
    }
    public double left_Y_stick_driver(){
        double yLeftValue = driver.getLeftY();
        if(Math.abs(yLeftValue)<tolerance){
            yLeftValue=0;
        }
        return yLeftValue;
    }

        public double right_X_stick_driver(){
        double xValue = driver.getRightX();
        if(Math.abs(xValue)<tolerance){
            xValue = 0;
        }
        return xValue;
    }
    public double right_Y_stick_driver(){
        double yValue = driver.getRightY();
        if(Math.abs(yValue)<tolerance){
            yValue=0;
        }
        return yValue;
    }

    public double right_trigger_axes(){
        double RAxisValue = driver.getRightTriggerAxis();
        if(Math.abs(RAxisValue)<tolerance){
            RAxisValue = 0;
        }
        return RAxisValue;
    }

    public double left_trigger_axis(){
        double LAxisValue = driver.getLeftTriggerAxis();
        if(Math.abs(LAxisValue)<tolerance){
            LAxisValue = 0;
        }
        return LAxisValue;
    }

    //MECANISMS-----------------------------------------

    public boolean Xbutton(){
        boolean Xbutton = mecanismos.getXButton(); 
        return Xbutton;
    }

    public boolean Ybutton(){
        boolean Ybutton = mecanismos.getYButton(); 
        return Ybutton;
    }

    public boolean Abutton(){
        boolean Abutton = mecanismos.getAButton(); 
        return Abutton;
    }

    public boolean Bbutton(){
        boolean Bbutton = mecanismos.getBButton(); 
        return Bbutton;
    }

    public double right_trigger_axis_mecanismos(){
        double right_trigger_axis_mecanismos = mecanismos.getRightTriggerAxis();
        if(Math.abs(right_trigger_axis_mecanismos)<tolerance){
            right_trigger_axis_mecanismos = 0;
        }        
        return right_trigger_axis_mecanismos;  
    }
    public double left_trigger_axis_mecanismos(){
        double left_trigger_axis_mecanismos = mecanismos.getLeftTriggerAxis();
        if(Math.abs(left_trigger_axis_mecanismos)<tolerance){
            left_trigger_axis_mecanismos = 0;
        }
        return left_trigger_axis_mecanismos;
    }    

    public double right_yJoyStick_Axis_mecanismos(){
        double right_yJoyStick_Axis = mecanismos.getLeftY();
        if(Math.abs(right_yJoyStick_Axis)<tolerance){
            right_yJoyStick_Axis = 0;
        }
        return right_yJoyStick_Axis;
    }

}