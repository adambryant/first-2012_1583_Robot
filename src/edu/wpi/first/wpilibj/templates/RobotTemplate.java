/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import com.rop.inputs.Driver;
import com.rop.outputs.BridgeDepressor;
import com.rop.outputs.Chassis;
import com.rop.outputs.Elevator;
import com.rop.outputs.Shooter;
import com.rop.outputs.ShooterReset;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot
{

    Driver driver = null;
    Chassis chassis = null;
    Elevator elevator = null;
    Shooter shooter = null;
    BridgeDepressor depressor = null;
    ShooterReset shooterReset = null;

    protected void disabled()
    {
        super.disabled();
    }

    protected void robotInit()
    {
        super.robotInit();
        driver = Driver.getInstance();
        chassis = Chassis.getInstance();
        elevator = Elevator.getInstance();
        shooter = Shooter.getInstance();
        depressor = BridgeDepressor.getInstance();
    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous()
    {
        // start shooter
        this.shooterReset = new ShooterReset(shooter);
        this.shooterReset.start();
        Timer.delay(0.5);

        // start elevator
        this.elevator.turnOn();

        System.out.println("0");

        // Wait for it to set mech first time
        while (this.shooterReset.isAlive())
            ;

        System.out.println("1");

        // start shooter - this will be first shot
        this.shooterReset = new ShooterReset(shooter);
        this.shooterReset.start();
        Timer.delay(0.5);

        System.out.println("2");

        System.out.println("3");

        // wait for shooter - this will be finish of the first shot
        while (this.shooterReset.isAlive())
            ;

        System.out.println("4");

        // Start shooter - this will fire the mechanism again
        this.shooterReset = new ShooterReset(shooter);
        this.shooterReset.start();
        Timer.delay(0.5);

        System.out.println("5");

        // stop elevator
        elevator.turnOff();

        System.out.println("6");
        
        // Turn around
        chassis.drive(0.5, 0);
        Timer.delay(3.0);
        chassis.stop();

        // drive forward
        chassis.drive(0.0, 0.5);
        Timer.delay(2.0);
        chassis.stop();
            
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl()
    {
        System.out.println("in OpControl");

        shooterReset = new ShooterReset(shooter);

        while (isEnabled())
        {
            // #### LIVE ROUTINES ####

            // Drive it
            chassis.drive(driver.getX(), driver.getY());

            // Run the elevator
            elevator.test(driver.getRightFrontSw());

            // Run the bridge depressor
            depressor.setSpeed(driver.getRot());

            // Shoot
            if (driver.getLeftFrontSw() == false)
            {
                if (!shooterReset.isAlive())
                {
                    shooterReset = new ShooterReset(shooter);
                    shooterReset.start();
                }
            }
        }
    }
}
