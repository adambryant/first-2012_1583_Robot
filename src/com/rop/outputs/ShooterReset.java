/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.outputs;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author adam
 */
public class ShooterReset extends Thread
{
    Shooter shooter = null;
    
    public ShooterReset(Shooter shooter)
    {
        this.shooter = shooter;
    }
    
    public void run()
    {
        // Run motor until limit switch is released
        shooter.turnOn();
//        while (shooter.getLimit() == true)
//        {
//            this.yield();
//        }
        // Wait one second so it can clear the switch before monitoring
        // the limit switch again.
        Timer t = new Timer();
        t.start();
        t.delay(1.0);
        
        // Run motor until limit switch is pressed
        while (shooter.getLimit() == false)
        {
            this.yield();
        }
        shooter.turnOff();
    }
    
}
