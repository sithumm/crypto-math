/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cryptomath;

import org.cryptomath.function.exception.CryptoMathException;
import java.math.BigInteger;
import java.text.MessageFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cryptomath.function.decorator.AbstractCryptoVector;
import org.cryptomath.function.decorator.DecoratorConfigSpec;
import org.cryptomath.function.decorator.HECryptoVectorDecorator;
import org.cryptomath.function.decorator.SimpleCryptoVector;
import org.cryptomath.function.exception.KeyGenerationException;
import org.cryptomath.function.key.CustomKeyPair;
import org.cryptomath.function.util.HEFunctionUtil;
import org.cryptomath.util.NumberUtil;
import thep.paillier.EncryptedInteger;
import thep.paillier.exceptions.BigIntegerClassNotValid;
import thep.paillier.exceptions.PublicKeysNotEqualException;

/**
 *
 * @author sithum
 */
public final class CryptoMath {

    private static final Log logger = LogFactory.getLog(CryptoMath.class);

    public static String add(final String a, final String b, final String alias) throws CryptoMathException {
	try {
	    logger.info(MessageFormat.format("Retrieving key pair for {0}", alias));
	    HEFunctionUtil util = new HEFunctionUtil();
	    CustomKeyPair kp = (CustomKeyPair) util.getKeyPair(alias);

	    EncryptedInteger ea = new EncryptedInteger(kp.getPublicKey());
	    ea.setCipherVal(new BigInteger(a));
	    EncryptedInteger eb = new EncryptedInteger(kp.getPublicKey());
	    ea.setCipherVal(new BigInteger(b));
	    logger.info("Adding encrypted values");
	    EncryptedInteger value = ea.add(eb);

	    return value.getCipherVal().toString();
	} catch (KeyGenerationException | BigIntegerClassNotValid | PublicKeysNotEqualException ex) {
	    logger.error("Adding given values failed", ex);
	    throw new CryptoMathException("Adding given values failed", ex);
	}
    }

    public static String addAndGetPlainValue(final String a, final String b, final String alias) throws CryptoMathException {
	try {
	    SimpleCryptoVector vector = new SimpleCryptoVector(CryptoMath.add(a, b, alias), DecoratorConfigSpec.DECRYPT_MODE);
	    HECryptoVectorDecorator decorator = new HECryptoVectorDecorator(vector, new DecoratorConfigSpec(DecoratorConfigSpec.DECRYPT_MODE, alias, null, -1));
	    
	    return decorator.getValue();
	} catch (KeyGenerationException | BigIntegerClassNotValid ex) {
	    logger.error("Adding given values failed", ex);
	    throw new CryptoMathException("Adding given values failed", ex);
	} catch (Exception ex) {
	    logger.error("Adding given values failed", ex);
	    throw new CryptoMathException("Adding given values failed", ex);
	}
    }

    public static String multiplyWithConstant(final String a, final String constant, final String alias) throws CryptoMathException {
	try {
	    logger.info(MessageFormat.format("Retrieving key pair for {0}", alias));
	    HEFunctionUtil util = new HEFunctionUtil();
	    CustomKeyPair kp = (CustomKeyPair) util.getKeyPair(alias);

	    EncryptedInteger ea = new EncryptedInteger(kp.getPublicKey());
	    ea.setCipherVal(new BigInteger(a));

	    logger.info(MessageFormat.format("Multiplying encrypted values {0}", alias));
	    BigInteger bi = new BigInteger(NumberUtil.absorbFloats(constant));
	    logger.info(">>>>>"+bi);
	    ea = ea.multiply(bi);

	    return ea.getCipherVal().toString();
	} catch (KeyGenerationException | BigIntegerClassNotValid ex) {
	    logger.error("Multiplying given values failed", ex);
	    throw new CryptoMathException("Multiplying given values failed", ex);
	}
    }

    public static String multiplyWithConstantAndGetPlainValue(final String a, final String constant, final String alias) throws CryptoMathException {
	try {
	    String encryptedResult = CryptoMath.multiplyWithConstant(a, constant, alias);
	    SimpleCryptoVector vector = new SimpleCryptoVector(encryptedResult, DecoratorConfigSpec.DECRYPT_MODE);
	    HECryptoVectorDecorator decorator = new HECryptoVectorDecorator(vector, new DecoratorConfigSpec(DecoratorConfigSpec.DECRYPT_MODE, alias, null, 2));
	    
	    return decorator.getValue();
	} catch (KeyGenerationException | BigIntegerClassNotValid ex) {
	    logger.error("Multiplying given values failed", ex);
	    throw new CryptoMathException("Multiplying given values failed", ex);
	} catch (Exception ex) {
	    logger.error("Multiplying given values failed", ex);
	    throw new CryptoMathException("Multiplying given values failed", ex);
	}
    }

    public AbstractCryptoVector multiply(final String a, final String b, final String alias, final String ivAlias) {
	return null;
    }

    public AbstractCryptoVector divide(final String a, final String b, final String alias, final String ivAlias) {
	return null;
    }

}
