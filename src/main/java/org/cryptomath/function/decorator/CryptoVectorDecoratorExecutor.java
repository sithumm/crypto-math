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
    
    public String encryptPaillierAES(final String message) throws Exception {
	DecoratorConfigSpec spec = new DecoratorConfigSpec(DecoratorConfigSpec.ENCRYPT_MODE, "he_key", null, -1);
	AbstractCryptoVector vector = new SimpleCryptoVector(message, spec.getMode());
//	System.out.println("vector::plain::"+vector.getValue());
	vector = new PaillierCryptoVectorDecorator(vector, spec);
//	System.out.println("vector::paillier::enc::"+vector.getValue());
	vector = new AESCryptoVectorDecorator(vector, new DecoratorConfigSpec(DecoratorConfigSpec.ENCRYPT_MODE, "aes_key", "aes_iv_alias", -1));
	
	return vector.getValue();
    }
    
    public String encryptRSAAES(final String message) throws Exception {
	DecoratorConfigSpec spec = new DecoratorConfigSpec(DecoratorConfigSpec.ENCRYPT_MODE, "rsa_key", null, -1);
	AbstractCryptoVector vector = new SimpleCryptoVector(message, spec.getMode());
//	System.out.println("vector::plain::"+vector.getValue());
	vector = new RSACryptoVectorDecorator(vector, spec);
//	System.out.println("vector::paillier::enc::"+vector.getValue());
	vector = new AESCryptoVectorDecorator(vector, new DecoratorConfigSpec(DecoratorConfigSpec.ENCRYPT_MODE, "aes_key", "aes_iv_alias", -1));
	
	return vector.getValue();
    }
    
    public String decryptPaillier(final String message) throws Exception {
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
    
    public String decryptRSA(final String message) throws Exception {
	DecoratorConfigSpec spec = new DecoratorConfigSpec(DecoratorConfigSpec.DECRYPT_MODE, "rsa_key", null, -1);
	AbstractCryptoVector vector = new SimpleCryptoVector(message, spec.getMode());
	
	vector = new RSACryptoVectorDecorator(vector, spec);
	return vector.getValue();
    }
    
    public String encryptRSA(final String message) throws Exception {
	DecoratorConfigSpec spec = new DecoratorConfigSpec(DecoratorConfigSpec.ENCRYPT_MODE, "rsa_key", null, -1);
	AbstractCryptoVector vector = new SimpleCryptoVector(message, spec.getMode());
	
	vector = new RSACryptoVectorDecorator(vector, spec);
	return vector.getValue();
    }
    
}
