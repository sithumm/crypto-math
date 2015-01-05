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
public class AESConfig {
    
    private String algorithm;
    private String scheme;
    private int keySize;
    private int ivSize;
    private final static Log logger = LogFactory.getLog(AESConfig.class);

    public String getAlgorithm() {
	logger.debug(String.format("algorithm::{0}", algorithm));
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getScheme() {
	logger.debug(String.format("scheme::{0}", scheme));
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public int getKeySize() {
	logger.debug(String.format("keySize::{0}", keySize));
        return keySize;
    }

    public void setKeySize(int keySize) {
        this.keySize = keySize;
    }

    public int getIvSize() {
	logger.debug(String.format("ivSize::{0}", ivSize));
        return ivSize;
    }

    public void setIvSize(int ivSize) {
        this.ivSize = ivSize;
    }
    
}
