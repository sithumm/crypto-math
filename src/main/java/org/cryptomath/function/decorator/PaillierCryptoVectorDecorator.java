/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.function.decorator;

import java.text.MessageFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cryptomath.function.PaillierCryptoFunction;
import org.cryptomath.function.exception.InvalidModeException;
import org.cryptomath.util.NumberUtil;

/**
 *
 * @author sithum
 */
public class PaillierCryptoVectorDecorator extends AbstractCryptoVectorDecorator {

    private static final Log logger = LogFactory.getLog(PaillierCryptoVectorDecorator.class);
    
    public PaillierCryptoVectorDecorator(AbstractCryptoVector vector, DecoratorConfigSpec config) {
	super(vector, config);
    }

    @Override
    public String getValue() throws Exception {
	PaillierCryptoFunction function = new PaillierCryptoFunction();
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
