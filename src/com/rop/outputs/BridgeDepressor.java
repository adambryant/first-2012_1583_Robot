/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rop.outputs;

import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Adam
 */
public class BridgeDepressor
{

    private static BridgeDepressor INSTANCE = null;
    Victor motor = null;
    Victor motor2 = null;

    private BridgeDepressor()
    {
        motor = new Victor(8);
        motor2 = new Victor(7);
    }

    public static BridgeDepressor getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new BridgeDepressor();

        return INSTANCE;
    }
    public void setSpeed(double speed)
    {
        motor.set(speed);
        motor2.set(speed);
    }
}
