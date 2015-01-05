/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cryptomath.function.exception;

/**
 *
 * @author sithum
 */
public class CryptoMathException extends Exception {

    public CryptoMathException(String message, java.lang.Exception ex) {
	super(message, ex);
    }
    
}
