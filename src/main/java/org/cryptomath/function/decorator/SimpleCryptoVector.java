/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cryptomath.function.decorator;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.cryptomath.util.NumberUtil;

/**
 *
 * @author sithum
 */
public class SimpleCryptoVector extends AbstractCryptoVector {

    public SimpleCryptoVector(final String value, final String mode) {
	if (DecoratorConfigSpec.ENCRYPT_MODE.equalsIgnoreCase(mode)) {
	    this.value = NumberUtil.absorbFloats(value);
	} else {
	    this.value = value;
	}
    }

    public SimpleCryptoVector(final long value, final String mode) {
	if (DecoratorConfigSpec.ENCRYPT_MODE.equalsIgnoreCase(mode)) {
	    this.value = NumberUtil.absorbFloats(new BigDecimal(value));
	} else {
	    throw new UnsupportedOperationException("Creating instance using a long is not supported in decryption mode");
	}
    }

    public SimpleCryptoVector(final double value, final String mode) {
	if (DecoratorConfigSpec.ENCRYPT_MODE.equalsIgnoreCase(mode)) {
	    this.value = NumberUtil.absorbFloats(new BigDecimal(value));
	} else {
	    throw new UnsupportedOperationException("Creating instance using a double is not supported in decryption mode");
	}
    }

    public SimpleCryptoVector(final BigInteger value, final String mode) {
	if (DecoratorConfigSpec.ENCRYPT_MODE.equalsIgnoreCase(mode)) {
	    this.value = NumberUtil.absorbFloats(new BigDecimal(value));
	} else {
	    throw new UnsupportedOperationException("Creating instance using a BigInteger is not supported in decryption mode");
	}
    }

    public SimpleCryptoVector(final BigDecimal value, final String mode) {
	if (DecoratorConfigSpec.ENCRYPT_MODE.equalsIgnoreCase(mode)) {
	    this.value = NumberUtil.absorbFloats(value);
	} else {
	    throw new UnsupportedOperationException("Creating instance using a BigDecimal is not supported in decryption mode");
	}
    }

    private String value;

    @Override
    public String getValue() {
	return this.value;
    }

    public void setValue(String value) {
	this.value = value;
    }

}
