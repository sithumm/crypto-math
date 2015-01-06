/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cryptomath.main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import org.cryptomath.CryptoMath;
import org.cryptomath.function.decorator.CryptoVectorDecoratorExecutor;

/**
 *
 * @author sithum
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
	CryptoVectorDecoratorExecutor executor = new CryptoVectorDecoratorExecutor();
	List<String> encrypted = new ArrayList<>(1000);
	BigInteger bi = new BigInteger("100");
	BigDecimal bd = new BigDecimal("100.222222224545111245444");
	System.out.println("<<<<<<<<<<<>>>>>>>>"+bd.scale()+"::"+bd.scaleByPowerOfTen(3).abs());
	for (int index = 0; index < 1; index++) {
	    String e = executor.encrypt(bd.toString());
	    System.out.println("encrypted::"+index+"::"+e);
	    encrypted.add(e);
	}
	
	BigInteger total = BigInteger.ZERO;
	for (String e : encrypted) {
	    String partial = new CryptoVectorDecoratorExecutor().decryptAES(e);
	    String full = new CryptoVectorDecoratorExecutor().decryptHE(partial);
	    System.out.println("full::"+full);
	    System.out.println("partial::"+CryptoMath.multiplyWithConstantAndGetPlainValue(partial, "2.56", "he_key"));
	    
	    System.out.println("divide::"+CryptoMath.divideWithConstantAndGetPlainValue(partial, "5", "he_key"));
//	    total = total.add(new BigInteger(partial));
	}
    }

}
