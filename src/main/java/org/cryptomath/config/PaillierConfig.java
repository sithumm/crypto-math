/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.config;

import java.math.BigInteger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author sithum
 */
public class PaillierConfig {
    
    private final static Log logger = LogFactory.getLog(PaillierConfig.class);
    private int keySize;
    private BigInteger threshold;

    public int getKeySize() {
        return keySize;
    }

    public void setKeySize(int keySize) {
        this.keySize = keySize;
    }

    /**
     * @return the threshold
     */
    public BigInteger getThreshold() {
	return threshold;
    }

    /**
     * @param threshold the threshold to set
     */
    public void setThreshold(BigInteger threshold) {
	this.threshold = threshold;
    }
    
}
