/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.function;

import java.math.BigInteger;
import org.cryptomath.function.key.CustomKeyPair;
import org.cryptomath.function.util.PaillierFunctionUtil;
import thep.paillier.EncryptedInteger;

/**
 *
 * @author sithum
 */
public class PaillierCryptoFunction implements ICryptoFunction{

    @Override
    public String encrypt(final String message, final String keyAlias, final String ivAlias) throws Exception {
	CustomKeyPair keyPair = (CustomKeyPair) new PaillierFunctionUtil().getKeyPair(keyAlias);
	EncryptedInteger ei = new EncryptedInteger(new BigInteger(message), keyPair.getPublicKey());
	
	return ei.getCipherVal().toString();
    }
    
    @Override
    public String decrypt(final String message, final String keyAlias, final String ivAlias) throws Exception {
	CustomKeyPair keyPair = (CustomKeyPair) new PaillierFunctionUtil().getKeyPair(keyAlias);
	EncryptedInteger ei = new EncryptedInteger(keyPair.getPublicKey());
	ei.setCipherVal(new BigInteger(message));
	
	return ei.decrypt(keyPair.getPrivateKey()).toString();
    }
    
}