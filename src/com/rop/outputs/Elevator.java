/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.outputs;

import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author Adam
 */
public class Elevator
{

    private static Elevator INSTANCE = null;
    Relay spike = null;

    private Elevator()
    {
        spike = new Relay(1);
        spike.setDirection(Relay.Direction.kForward);
    }

    public static Elevator getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new Elevator();

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
    public void test(boolean flag)
    {
       if (flag)
           turnOn();
       else
           turnOff();
       
    }
}
   