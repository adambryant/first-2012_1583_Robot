/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.inputs;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author adam
 */
public class LimitSwitch
{
    DigitalInput di = new DigitalInput(1);
    
    public boolean get()
    {
        return di.get();
    }
}
