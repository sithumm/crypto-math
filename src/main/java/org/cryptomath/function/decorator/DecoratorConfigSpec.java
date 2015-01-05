/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.function.decorator;

/**
 *
 * @author sithum
 */
public class DecoratorConfigSpec {

    public DecoratorConfigSpec(String mode, String keyAlias, String ivAlias, int pTimes) {
	this.mode = mode;
	this.keyAlias = keyAlias;
	this.ivAlias = ivAlias;
	if (pTimes > 0) {
	    this.pTimes = pTimes;
	}
    }

    public DecoratorConfigSpec() {
    }
    
    public final static String ENCRYPT_MODE = "ENCRYPT_MODE";
    public final static String DECRYPT_MODE = "DECRYPT_MODE";
    
    private String mode;
    private String keyAlias;
    private String ivAlias;
    private int pTimes = 1;

    /**
     * @return the mode
     */
    public String getMode() {
	return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(String mode) {
	this.mode = mode;
    }

    /**
     * @return the keyAlias
     */
    public String getKeyAlias() {
	return keyAlias;
    }

    /**
     * @param keyAlias the keyAlias to set
     */
    public void setKeyAlias(String keyAlias) {
	this.keyAlias = keyAlias;
    }

    /**
     * @return the ivAlias
     */
    public String getIvAlias() {
	return ivAlias;
    }

    /**
     * @param ivAlias the ivAlias to set
     */
    public void setIvAlias(String ivAlias) {
	this.ivAlias = ivAlias;
    }

    /**
     * @return the pTimes
     */
    public int getpTimes() {
	return pTimes;
    }

    /**
     * @param pTimes the pTimes to set
     */
    public void setpTimes(int pTimes) {
	this.pTimes = pTimes;
    }
    
}