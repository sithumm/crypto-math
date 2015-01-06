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
public class CryptoVectorDecoratorExecutor {
    
    public String encrypt(final String message) throws Exception {
	DecoratorConfigSpec spec = new DecoratorConfigSpec(DecoratorConfigSpec.ENCRYPT_MODE, "he_key", null, -1);
	AbstractCryptoVector vector = new SimpleCryptoVector(message, spec.getMode());
	
	vector = new PaillierCryptoVectorDecorator(vector, spec);
	System.out.println("vector::he::enc::"+vector.getValue());
//	spec.setKeyAlias();
//	spec.setIvAlias("aes_iv_alias");
	vector = new AESCryptoVectorDecorator(vector, new DecoratorConfigSpec(DecoratorConfigSpec.ENCRYPT_MODE, "aes_key", "aes_iv_alias", -1));
	
	return vector.getValue();
    }
    
    public String decryptHE(final String message) throws Exception {
	DecoratorConfigSpec spec = new DecoratorConfigSpec(DecoratorConfigSpec.DECRYPT_MODE, "he_key", null, -1);
	AbstractCryptoVector vector = new SimpleCryptoVector(message, spec.getMode());
	
	vector = new PaillierCryptoVectorDecorator(vector, spec);
	return vector.getValue();
    }
    
    public String decryptAES(final String message) throws Exception {
	DecoratorConfigSpec spec = new DecoratorConfigSpec(DecoratorConfigSpec.DECRYPT_MODE, "aes_key", "aes_iv_alias", -1);
	AbstractCryptoVector vector = new SimpleCryptoVector(message, spec.getMode());
	
	vector = new AESCryptoVectorDecorator(vector, spec);
	return vector.getValue();
    }
    
}
