/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cryptomath.main;

import java.math.BigInteger;
import org.cryptomath.CryptoMath;
import org.cryptomath.function.RSACryptoFunction;
import org.cryptomath.function.decorator.CryptoVectorDecoratorExecutor;

/**
 *
 * @author sithum
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
//	CryptoVectorDecoratorExecutor executor = new CryptoVectorDecoratorExecutor();
//	List<String> encrypted = new ArrayList<>(1000);
//	BigInteger bi = new BigInteger("100");
//	BigDecimal bd = new BigDecimal("100.222222224545111245444");
//	System.out.println("<<<<<<<<<<<>>>>>>>>"+bd.scale()+"::"+bd.scaleByPowerOfTen(3).abs());
//	for (int index = 0; index < 1; index++) {
//	    String e = executor.encryptPaillierAES(bd.toString());
//	    System.out.println("encrypted::"+index+"::"+e);
//	    encrypted.add(e);
//	}
//	
//	BigInteger total = BigInteger.ZERO;
//	for (String e : encrypted) {
//	    String partial = new CryptoVectorDecoratorExecutor().decryptAES(e);
//	    String full = new CryptoVectorDecoratorExecutor().decryptPaillier(partial);
//	    System.out.println("full::"+full);
//	    System.out.println("partial::"+CryptoMath.multiplyWithConstantAndGetPlainValue(partial, "2.56", "he_key"));
//	    
//	    System.out.println("divide::"+CryptoMath.divideWithConstantAndGetPlainValue(partial, "5", "he_key"));
////	    total = total.add(new BigInteger(partial));
//	}
	
	String full1 = new CryptoVectorDecoratorExecutor().encryptRSAAES("1500000");
	String full2 = new CryptoVectorDecoratorExecutor().encryptRSAAES("5.3");
	
	System.out.println("full1::"+full1);
	System.out.println("full2::"+full2);
	
	String rsa1 = new CryptoVectorDecoratorExecutor().decryptAES(full1);
	String rsa2 = new CryptoVectorDecoratorExecutor().decryptAES(full2);
	
	System.out.println("rsa1::"+new CryptoVectorDecoratorExecutor().decryptRSA(rsa1));
	System.out.println("rsa2::"+new CryptoVectorDecoratorExecutor().decryptRSA(rsa2));
	System.out.println("multiplied::"+CryptoMath.multiplyAndGetPlainValue(rsa1, rsa2, "rsa_key"));
	
//	RSACryptoFunction f1 = new RSACryptoFunction();
//	String s = f1.encrypt("150000", "rsa_key", null);
//	System.out.println(s);
//	String d = f1.decrypt(s, "rsa_key", null);
//	System.out.println(new BigInteger(d));
    }

}
