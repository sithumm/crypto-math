/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.function.util;

import javax.crypto.SecretKey;
import org.cryptomath.function.exception.KeyGenerationException;

/**
 *
 * @author sithum
 */
public interface CryptoFunctionUtil {
    
    void generateKeys(String alias) throws KeyGenerationException;
    
    void generateIV(String alias) throws Exception;
    
    Object getKeyPair(String alias) throws KeyGenerationException;
    
    byte[] getSecretKey(String alias) throws KeyGenerationException;
    
    byte[] getIV(String  alias) throws Exception;
    
}
