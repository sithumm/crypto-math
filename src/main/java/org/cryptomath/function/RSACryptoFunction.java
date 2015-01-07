/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.function;

import java.math.BigInteger;
import org.apache.commons.codec.binary.Base64;
import org.cryptomath.function.util.RSAFunctionUtil;
import org.he.rsa.RSACipher;
import org.he.rsa.key.KeyPair;

/**
 *
 * @author sithum
 */
public class RSACryptoFunction implements ICryptoFunction {

    @Override
    public String encrypt(final String message, final String keyAlias, final String ivAlias) throws Exception {
	KeyPair pair = (KeyPair) new RSAFunctionUtil().getKeyPair(keyAlias);
	RSACipher cipher = new RSACipher();
	cipher.init(RSACipher.ENCRYPT_MODE, pair.getPublicKey());
	
	byte[] encrypted = cipher.doFinal(new BigInteger(message).toByteArray());
	return new String(Base64.encodeBase64(encrypted));
    }

    @Override
    public String decrypt(final String message, final String keyAlias, final String ivAlias) throws Exception {
	KeyPair pair = (KeyPair) new RSAFunctionUtil().getKeyPair(keyAlias);
	RSACipher cipher = new RSACipher();
	cipher.init(RSACipher.DECRYPT_MODE, pair.getPrivateKey());
	
	byte[] plain = cipher.doFinal(Base64.decodeBase64(message.getBytes()));
	return new BigInteger(plain).toString();
    }
    
}
