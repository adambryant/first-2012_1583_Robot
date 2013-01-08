/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.outputs.motor;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Watchdog;

/**
 *
 * @author Adam
 */
public class CalibrateJaguar extends Thread
{
    Jaguar jag = null;
    
    public CalibrateJaguar(Jaguar jag)
    {
        this.jag = jag;
    }
    
    public void run()
    {
        Watchdog.getInstance().setEnabled(false);
        
        while (true)
        {
            
            jag.set(-1.0);
            Timer.delay(5.0);
            jag.set(1.0);
            Timer.delay(5.0);
        }
    }
}
