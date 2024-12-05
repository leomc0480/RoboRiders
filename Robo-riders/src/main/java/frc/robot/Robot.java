
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
//IMPORTADOS-------------------------------------------
import frc.robot.Control_Board.Control;
import frc.robot.subsystems.Chasis;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Conos;   
import edu.wpi.first.wpilibj.Timer;

/*Orden de Controllers --------------------------------
1 = frontleft
2 = backleft
3 = rightfront
4 = rightback 
5 = moverbrazito
6 = leftshooter
7 = rightshooter
8 = comercono
*/

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  Chasis mChasis;
  Control mControl;
  Intake mIntake;
  Conos mConos;

  private RobotContainer m_robotContainer;

  private final Timer absoluteTimer = new Timer();
  private final Timer relativeTimer = new Timer();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    mChasis = new Chasis();
    mIntake = new Intake();
    mConos = new Conos();
    mControl = new Control();
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }

    // Start both absolute and relative timers
    absoluteTimer.reset();
    absoluteTimer.start();
    relativeTimer.reset();
    relativeTimer.start();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

    double absoluteTime = absoluteTimer.get();
    double relativeTime = relativeTimer.get();
    
    if (absoluteTime < 2) {
      // Forward for the first 5 seconds
     mChasis.driveAutonomous();
   /*  } else if (absoluteTime < 7.5) {
      // Reverse for the next 2.5 seconds
      if (relativeTime >= 2.5) relativeTimer.reset();  // Reset relative timer for next phase
     
    } else if (absoluteTime < 10.0) {
      // Forward for the next 2.5 seconds
      if (relativeTime >= 2.5) relativeTimer.reset();
  
    } else if (absoluteTime < 12.5) {
      // Move to the right for the next 2.5 seconds
      if (relativeTime >= 2.5) relativeTimer.reset();
   
    } else if (absoluteTime < 15.0) {
      // Move to the left for the final 2.5 seconds
      if (relativeTime >= 2.5) relativeTimer.reset();
   */
    } else {
      // Stop all motors after 15 seconds
      mChasis.stop();
      mConos.stop();
      mIntake.stop();
      absoluteTimer.stop();
    }
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
mChasis.drive(mControl.right_X_stick_driver(), mControl.left_Y_stick_driver());
mIntake.comer(mControl.left_trigger_axis(), mControl.right_trigger_axes());
mConos.comer(mControl.right_trigger_axis_mecanismos(), mControl.left_trigger_axis_mecanismos());
mConos.mover(mControl.right_yJoyStick_Axis_mecanismos());
 }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
