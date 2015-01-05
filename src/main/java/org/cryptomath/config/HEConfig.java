/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author sithum
 */
public class HEConfig {
    
    private final static Log logger = LogFactory.getLog(HEConfig.class);
    private int keySize;

    public int getKeySize() {
	logger.debug(String.format("algorithm::{0}", keySize));
        return keySize;
    }

    public void setKeySize(int keySize) {
        this.keySize = keySize;
    }
    
}
