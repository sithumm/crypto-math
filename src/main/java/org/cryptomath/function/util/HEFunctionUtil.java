/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.function.util;

import org.cryptomath.function.exception.KeyGenerationException;
import org.cryptomath.config.CryptoConfigSpec;
import org.cryptomath.config.HEConfig;
import org.cryptomath.function.key.CustomKeyPair;
import org.cryptomath.util.PersistenceKeyStoreIOHandler;
import thep.paillier.PrivateKey;
import thep.paillier.PublicKey;

/**
 *
 * @author sithum
 */
public class HEFunctionUtil implements CryptoFunctionUtil {

    @Override
    public void generateKeys(String alias) throws KeyGenerationException {
        HEConfig heConfig = CryptoConfigSpec.getInstance().getHeConfig();
        PrivateKey privateKey = new PrivateKey(heConfig.getKeySize());
        PublicKey publicKey = privateKey.getPublicKey();
        CustomKeyPair keyPair = new CustomKeyPair(publicKey, privateKey);
        
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
