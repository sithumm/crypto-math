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
public class AbstractCryptoVectorDecorator extends AbstractCryptoVector {
    
    protected final AbstractCryptoVector vector;
    protected final DecoratorConfigSpec config;

    public AbstractCryptoVectorDecorator(final AbstractCryptoVector vector, final DecoratorConfigSpec config) {
	this.vector = vector;
	this.config = config;
    }
    
    @Override
    public String getValue() throws Exception{
	return vector.getValue();
    }
    
}
