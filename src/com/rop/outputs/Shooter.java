/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.outputs;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author Adam
 */
public class Shooter
{

    private static Shooter INSTANCE = null;
    Relay spike = null;
    DigitalInput limit = null;

    private Shooter()
    {
        spike = new Relay(2);
        spike.setDirection(Relay.Direction.kForward);
        limit = new DigitalInput(1);
    }

    public static Shooter getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new Shooter();
        }

        return INSTANCE;
    }

    public void turnOn()
    {
        spike.set(Relay.Value.kForward);
    }

    public void turnOff()
    {
        spike.set(Relay.Value.kOff);
    }
    
    public boolean getLimit()
    {
        return limit.get();
    }
    
    public void test(boolean flag)
    {
       if (flag)
           turnOn();
       else
           turnOff();
       
    }
}
   