/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cryptomath.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.MessageFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cryptomath.config.CryptoConfigSpec;

/**
 *
 * @author sithum
 */
public class NumberUtil {

    public static final Log logger = LogFactory.getLog(NumberUtil.class);

    public static String absorbFloats(String value) {
	String result;
	if (value.matches("[\\d]*.[\\d]*")) {
	    logger.info("Absorbing floats");
	    BigDecimal bd = new BigDecimal(value);
	    int f = CryptoConfigSpec.getInstance().getMathConfig().getFractions();
//	    logger.info("Absorbed value::check" + value);
//	    logger.info("Absorbed value::check" + bd);
	    bd = bd.multiply(new BigDecimal("10").pow(f));
//            logger.info("Absorbed value::check" + bd);
	    String[] tokens = bd.toString().split("\\.");
	    result = tokens[0];
//	    result = truncate(value, f).toString();
	    logger.info("Absorbed value::check::" + result);
	} else {
	    throw new NumberFormatException(MessageFormat.format("Invalid argument {0}", value));
	}
	return result;
    }

    public static String absorbFloats(BigDecimal value) {
	return NumberUtil.absorbFloats(value.toString());
    }

    public static String spillFloats(String value, final int pTimes) {
	String result;
	if (value.matches("[\\d]*")) {

	    BigDecimal bd = new BigDecimal(value);
	    int f = CryptoConfigSpec.getInstance().getMathConfig().getFractions();
	    bd = bd.divide(new BigDecimal("10").pow(f * pTimes));

	    result = bd.toString();
	} else {
	    throw new NumberFormatException(MessageFormat.format("Invalid argument {0}", value));
	}
	return result;
    }

    public static String spillFloats(BigInteger value, final int pTimes) {
	return NumberUtil.spillFloats(value.toString(), pTimes);
    }

    public static BigDecimal truncate(final String text, final int pTimes) {
	BigDecimal bigDecimal = new BigDecimal(text);
	if (bigDecimal.scale() > pTimes) {
	    bigDecimal = new BigDecimal(text).setScale(pTimes, RoundingMode.HALF_UP);
	}
	return bigDecimal.stripTrailingZeros();
    }

    private static void check(final BigDecimal bigDecimal, final String string) {
	if (!bigDecimal.toString().equals(string)) {
	    throw new IllegalStateException("not equal: " + bigDecimal + " and " + string);
	}
    }

    public static void main(String[] args) {
	System.out.println(NumberUtil.absorbFloats("100.222222224545111245444"));
	System.out.println(absorbFloats(new BigDecimal(0.002343)));
	System.out.println(NumberUtil.absorbFloats("1000002343"));
	System.out.println(absorbFloats(new BigDecimal("1000002343")));
	System.out.println("100000".matches("[\\d]*"));
	System.out.println(NumberUtil.spillFloats("1000002343", 1));
	System.out.println(spillFloats(new BigInteger("1000002343"), 1));
	System.out.println(NumberUtil.spillFloats("1000002343", 2));
	System.out.println(spillFloats(new BigInteger("1000002343"), 2));
    }

}
