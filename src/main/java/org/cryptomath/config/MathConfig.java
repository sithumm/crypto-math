/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.config;

import java.text.MessageFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author sithum
 */
public class MathConfig {
    
    private final static Log logger = LogFactory.getLog(MathConfig.class);
    private int fractions;

    /**
     * @return the fractions
     */
    public int getFractions() {
	logger.info(MessageFormat.format("fractions::{0}", fractions));
        return fractions;
    }

    /**
     * @param fractions the fractions to set
     */
    public void setFractions(int fractions) {
        this.fractions = fractions;
    }
    
}
