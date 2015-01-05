/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.config;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sithum
 */
public class DecoratorConfig {
    
    public static final Integer ENCRYPT_HE_AES = 1;
    public static final Integer DECRYPT_HE = 1;
    public static final Integer DECRYPT_AES = 2;
    
    private Map<Integer, String> encryptDecorators = new HashMap<>();
    private Map<Integer, String> decryptDecorators = new HashMap<>();

    /**
     * @return the encryptDecorators
     */
    public Map<Integer, String> getEncryptDecorators() {
	return encryptDecorators;
    }

    /**
     * @param encryptDecorators the encryptDecorators to set
     */
    public void setEncryptDecorators(Map<Integer, String> encryptDecorators) {
	this.encryptDecorators = encryptDecorators;
    }

    /**
     * @return the decryptDecorators
     */
    public Map<Integer, String> getDecryptDecorators() {
	return decryptDecorators;
    }

    /**
     * @param decryptDecorators the decryptDecorators to set
     */
    public void setDecryptDecorators(Map<Integer, String> decryptDecorators) {
	this.decryptDecorators = decryptDecorators;
    }
}