/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.function.decorator;

import org.cryptomath.function.exception.InvalidModeException;
import org.cryptomath.function.AESCryptoFunction;

/**
 *
 * @author sithum
 */
public class AESCryptoVectorDecorator extends AbstractCryptoVectorDecorator {
    
    public AESCryptoVectorDecorator(final AbstractCryptoVector vector, final DecoratorConfigSpec config) {
	super(vector, config);
    }

    @Override
    public String getValue() throws Exception {
	AESCryptoFunction function = new AESCryptoFunction();
	String message;
	switch (this.config.getMode()) {
	    case DecoratorConfigSpec.ENCRYPT_MODE:
		message = function.encrypt(super.getValue(), this.config.getKeyAlias(), this.config.getIvAlias());
		break;
	    case DecoratorConfigSpec.DECRYPT_MODE:
		message = function.decrypt(super.getValue(), this.config.getKeyAlias(), this.config.getIvAlias());
		break;
	    default:
		throw new InvalidModeException(String.format("Invalid cryptographic mode. Should be either {0} or {1}", DecoratorConfigSpec.ENCRYPT_MODE, DecoratorConfigSpec.DECRYPT_MODE));
	}
	return message;
    }
    
}
