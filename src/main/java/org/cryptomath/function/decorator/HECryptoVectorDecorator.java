/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.function.decorator;

import java.text.MessageFormat;
import org.cryptomath.function.HECryptoFunction;
import org.cryptomath.function.exception.InvalidModeException;
import org.cryptomath.util.NumberUtil;

/**
 *
 * @author sithum
 */
public class HECryptoVectorDecorator extends AbstractCryptoVectorDecorator {

    public HECryptoVectorDecorator(AbstractCryptoVector vector, DecoratorConfigSpec config) {
	super(vector, config);
    }

    @Override
    public String getValue() throws Exception {
	HECryptoFunction function = new HECryptoFunction();
	String message;
	switch (this.config.getMode()) {
	    case DecoratorConfigSpec.ENCRYPT_MODE:
		message = function.encrypt(super.getValue(), this.config.getKeyAlias(), null);
		break;
	    case DecoratorConfigSpec.DECRYPT_MODE:
		message = function.decrypt(super.getValue(), this.config.getKeyAlias(), null);
		message = NumberUtil.spillFloats(message, this.config.getpTimes());
		break;
	    default:
		throw new InvalidModeException(MessageFormat.format("Invalid cryptographic mode. Should be either {0} or {1}", DecoratorConfigSpec.ENCRYPT_MODE, DecoratorConfigSpec.DECRYPT_MODE));
	}
	return message;
    }
    
}
