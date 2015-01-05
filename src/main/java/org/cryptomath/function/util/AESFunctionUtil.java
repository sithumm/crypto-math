/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cryptomath.function.util;

import org.cryptomath.function.exception.KeyGenerationException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.cryptomath.config.AESConfig;
import org.cryptomath.config.CryptoConfigSpec;
import org.cryptomath.util.PersistenceKeyStoreIOHandler;

/**
 *
 * @author sithum
 */
public class AESFunctionUtil implements CryptoFunctionUtil {

    @Override
    public void generateKeys(String alias) throws KeyGenerationException {
	try {
	    AESConfig config = CryptoConfigSpec.getInstance().getAesConfig();
	    KeyGenerator keyGen = KeyGenerator.getInstance(config.getScheme());
	    keyGen.init(config.getKeySize());
	    SecretKey key = keyGen.generateKey();

	    PersistenceKeyStoreIOHandler.getInstance().storeKey(alias, key);
	} catch (NoSuchAlgorithmException ex) {
	    throw new KeyGenerationException(ex.getMessage(), ex);
	}
    }

    @Override
    public void generateIV(String alias) throws Exception {
	byte[] ivSalt = SecureRandom.getSeed(16);
	PersistenceKeyStoreIOHandler.getInstance().storeIV(ivSalt, alias);
    }

    @Override
    public Object getKeyPair(String alias) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public byte[] getSecretKey(String alias) throws KeyGenerationException {
	SecretKey key = (SecretKey) PersistenceKeyStoreIOHandler.getInstance().getKey(alias);
	if (key == null) {
	    this.generateKeys(alias);
	    key = (SecretKey) PersistenceKeyStoreIOHandler.getInstance().getKey(alias);
	}
//	return Base64.encodeBase64(key.getEncoded());
	return key.getEncoded();
    }

    @Override
    public byte[] getIV(String alias) throws Exception {
	byte[] iv = null;
	try {
	    iv = PersistenceKeyStoreIOHandler.getInstance().getIV(alias);
	} catch (Exception ex) {
	    System.out.println(ex.getMessage() + "::Genrating IV");
	}
	if (iv == null || !(iv.length > 0)) {
	    this.generateIV(alias);
	    iv = PersistenceKeyStoreIOHandler.getInstance().getIV(alias);
	}
	return iv;
    }

}
