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
public class KeyGenerationException extends Exception {

    public KeyGenerationException(String message) {
        super(message);
    }

    public KeyGenerationException() {
    }
    
    public KeyGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}
