/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.function.util;

import org.cryptomath.config.CryptoConfigSpec;
import org.cryptomath.config.RSAConfig;
import org.cryptomath.function.exception.KeyGenerationException;
import org.cryptomath.util.PersistenceKeyStoreIOHandler;
import org.he.rsa.KeyGenerator;
import org.he.rsa.key.KeyPair;

/**
 *
 * @author sithum
 */
public class RSAFunctionUtil implements CryptoFunctionUtil {

    @Override
    public void generateKeys(String alias) throws KeyGenerationException {
	RSAConfig config = CryptoConfigSpec.getInstance().getRsaConfig();
        KeyPair keyPair = KeyGenerator.generateKeyPair(config.getKeySize());
	
	PersistenceKeyStoreIOHandler.getInstance().storeKey(alias, keyPair);
    }

    @Override
    public void generateIV(String alias) throws Exception {
        throw new UnsupportedOperationException("Invalid operation");
    }

    @Override
    public Object getKeyPair(String alias) throws KeyGenerationException {
        Object keyPair = PersistenceKeyStoreIOHandler.getInstance().getKey(alias);
	if (keyPair == null) {
	    this.generateKeys(alias);
	    keyPair = PersistenceKeyStoreIOHandler.getInstance().getKey(alias);
	}
        return keyPair;
    }

    @Override
    public byte[] getSecretKey(String alias) {
        throw new UnsupportedOperationException("Invalid operation");
    }

    @Override
    public byte[] getIV(String alias) throws Exception {
        throw new UnsupportedOperationException("Invalid operation");
    }
}
