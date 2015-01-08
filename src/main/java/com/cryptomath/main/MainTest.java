/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cryptomath.main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.cryptomath.CryptoMath;
import org.cryptomath.function.decorator.CryptoVectorDecoratorExecutor;
import org.cryptomath.function.key.CustomKeyPair;
import org.cryptomath.util.PersistenceKeyStoreIOHandler;
import thep.paillier.EncryptedInteger;

/**
 *
 * @author sithum
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
//	CryptoVectorDecoratorExecutor executor = new CryptoVectorDecoratorExecutor();
//		
//	String full1 = new CryptoVectorDecoratorExecutor().encryptRSAAES("1500000");
//	String full2 = new CryptoVectorDecoratorExecutor().encryptRSAAES("5.3");
//	
//	System.out.println("full1::"+full1);
//	System.out.println("full2::"+full2);
//	
//	String rsa1 = new CryptoVectorDecoratorExecutor().decryptAES(full1);
//	String rsa2 = new CryptoVectorDecoratorExecutor().decryptAES(full2);
//	
//	System.out.println("rsa1::"+new CryptoVectorDecoratorExecutor().decryptRSA(rsa1));
//	System.out.println("rsa2::"+new CryptoVectorDecoratorExecutor().decryptRSA(rsa2));
//	System.out.println("multiplied::"+CryptoMath.multiplyAndGetPlainValue(rsa1, rsa2, "rsa_key"));
//	
	String s1 = new CryptoVectorDecoratorExecutor().encryptPaillierAES("1500000");
	String s2 = new CryptoVectorDecoratorExecutor().encryptPaillierAES("260");
	String s3 = new CryptoVectorDecoratorExecutor().encryptPaillierAES("15");
	
	String s11 = new CryptoVectorDecoratorExecutor().decryptAES(s1);
	String s12 = new CryptoVectorDecoratorExecutor().decryptAES(s2);
	String s13 = new CryptoVectorDecoratorExecutor().decryptAES(s3);
	
//	CustomKeyPair kp = (CustomKeyPair) PersistenceKeyStoreIOHandler.getInstance().getKey("he_key");
//	EncryptedInteger ei3 = new EncryptedInteger(kp.getPublicKey());
//	ei3.setCipherVal(new BigInteger(s11));
//	EncryptedInteger ei4 = new EncryptedInteger(kp.getPublicKey());
//	ei4.setCipherVal(new BigInteger(s12));
//	System.out.println(ei3.add(ei4).decrypt(kp.getPrivateKey()));
	
	System.out.println(CryptoMath.addAndGetPlainValue(s11, s12, "he_key"));
	System.out.println(CryptoMath.subtractAndGetPlainValue(s12, s13, "he_key"));
	
//	CustomKeyPair kp = (CustomKeyPair) PersistenceKeyStoreIOHandler.getInstance().getKey("he_key");
//	
//	EncryptedInteger ei1 = new EncryptedInteger(new BigInteger("100"), kp.getPublicKey());
//	String s1 = ei1.getCipherVal().toString();
//	
//	EncryptedInteger ei2 = new EncryptedInteger(new BigInteger("50"), kp.getPublicKey());
//	String s2 = ei2.getCipherVal().toString();
//	
//	EncryptedInteger ei3 = new EncryptedInteger(kp.getPublicKey());
//	ei3.setCipherVal(new BigInteger(s1));
//	EncryptedInteger ei4 = new EncryptedInteger(kp.getPublicKey());
//	ei4.setCipherVal(new BigInteger(s2));
//	System.out.println(ei3.add(ei4).decrypt(kp.getPrivateKey()));
    }

}
