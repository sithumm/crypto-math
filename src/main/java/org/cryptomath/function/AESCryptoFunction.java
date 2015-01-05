/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.function;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.cryptomath.config.AESConfig;
import org.cryptomath.config.CryptoConfigSpec;
import org.cryptomath.function.util.AESFunctionUtil;

/**
 *
 * @author sithum
 */
public class AESCryptoFunction implements ICryptoFunction {

    @Override
    public String encrypt(final String message, final String keyAlias, final String ivAlias) throws Exception {
        AESConfig config = CryptoConfigSpec.getInstance().getAesConfig();
	Cipher cipher = Cipher.getInstance(config.getAlgorithm(), "BC");

	AESFunctionUtil util = new AESFunctionUtil();
        IvParameterSpec iv = new IvParameterSpec(util.getIV(ivAlias));
	
        SecretKeySpec keySpec = new SecretKeySpec(util.getSecretKey(keyAlias), config.getScheme());

        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

        byte[] cipherText = cipher.doFinal(message.getBytes());

        return new String(Base64.encodeBase64(cipherText));
    }

    @Override
    public String decrypt(String message, String keyAlias, String ivAlias) throws Exception {
	AESConfig config = CryptoConfigSpec.getInstance().getAesConfig();
        Cipher cipher = Cipher.getInstance(config.getAlgorithm(), "BC");

	AESFunctionUtil util = new AESFunctionUtil();
        IvParameterSpec iv = new IvParameterSpec(util.getIV(ivAlias));
	SecretKeySpec keySpec = new SecretKeySpec(util.getSecretKey(keyAlias), config.getScheme());
	
        cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);

        byte[] plainText = cipher.doFinal(Base64.decodeBase64(message.getBytes()));
	
        return new String(plainText);
    }
    
}
