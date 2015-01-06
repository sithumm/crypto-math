/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.function;

import org.cryptomath.function.util.RSAFunctionUtil;
import org.he.rsa.RSACipher;
import org.he.rsa.key.KeyPair;

/**
 *
 * @author sithum
 */
public class RSACryptoFunction implements ICryptoFunction {

    @Override
    public String encrypt(String message, String keyAlias, String ivAlias) throws Exception {
	KeyPair pair = (KeyPair) new RSAFunctionUtil().getKeyPair(keyAlias);
	RSACipher cipher = new RSACipher();
	cipher.init(RSACipher.ENCRYPT_MODE, pair.getPublicKey());
	
	byte[] encrypted = cipher.doFinal(message.getBytes());
	return new String(encrypted);
    }

    @Override
    public String decrypt(String message, String keyAlias, String ivAlias) throws Exception {
	KeyPair pair = (KeyPair) new RSAFunctionUtil().getKeyPair(keyAlias);
	RSACipher cipher = new RSACipher();
	cipher.init(RSACipher.DECRYPT_MODE, pair.getPrivateKey());
	
	byte[] plain = cipher.doFinal(message.getBytes());
	return new String(plain);
    }
    
}
