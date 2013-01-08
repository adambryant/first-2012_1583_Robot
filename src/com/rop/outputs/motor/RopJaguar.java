/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.outputs.motor;

import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author Adam
 */
public class RopJaguar extends Jaguar
{
    Jaguar motor = null;
    boolean reversed = false;
    
    public RopJaguar(int channel, boolean reversed)
    {
        super(channel);
        this.reversed = reversed;
    }
    
    public void set(double speed)
    {
        if (reversed)
            super.set(speed * -1.0);
        else
            super.set(speed);
    }
}
