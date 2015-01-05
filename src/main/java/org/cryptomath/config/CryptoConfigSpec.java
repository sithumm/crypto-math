/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cryptomath.config;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author sithum
 */
public class CryptoConfigSpec {

    private MathConfig mathConfig;
    private DecoratorConfig decoratorConfig;
    private AESConfig aesConfig;
    private HEConfig heConfig;
    private RSAConfig rsaConfig;

    private static final String CONFIG = "config.properties";

    private static CryptoConfigSpec instance = null;
    private final Properties config = new Properties();

    private CryptoConfigSpec() {
        this.load();
    }

    public static CryptoConfigSpec getInstance() {
        synchronized (CryptoConfigSpec.class) {
            if (instance == null) {
                instance = new CryptoConfigSpec();
            }
            return instance;
        }
    }

    private void load() {
        try {
            config.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG));
            loadMathConfig(config);
            loadDecoratorConfig(config);
            loadAESConfig(config);
            loadHEConfig(config);
            loadRSAConfig(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRSAConfig(final Properties config) {
        if (rsaConfig == null) {
            rsaConfig = new RSAConfig();
        }
    }

    private void loadHEConfig(final Properties config) {
        if (heConfig == null) {
            heConfig = new HEConfig();
        }
        heConfig.setKeySize(Integer.parseInt(config.getProperty("crypto.config.he.keysize", "128")));
    }

    private void loadAESConfig(final Properties config) {
        if (aesConfig == null) {
            aesConfig = new AESConfig();
        }
        aesConfig.setAlgorithm(config.getProperty("crypto.config.aes.algorithm", "AES/CTR/NoPadding"));
        aesConfig.setScheme(config.getProperty("crypto.config.aes.scheme", "AES"));
        aesConfig.setKeySize(Integer.parseInt(config.getProperty("crypto.config.aes.keysize", "128")));
        aesConfig.setIvSize(Integer.parseInt(config.getProperty("crypto.config.aes.ivsize", "16")));
    }

    private void loadDecoratorConfig(final Properties config) {
        if (decoratorConfig == null) {
            decoratorConfig = new DecoratorConfig();
        }
	decoratorConfig.getEncryptDecorators().put(DecoratorConfig.ENCRYPT_HE_AES, this.config.getProperty("crypto.config.decorator.encrypt.1"));
	decoratorConfig.getDecryptDecorators().put(DecoratorConfig.DECRYPT_HE, this.config.getProperty("crypto.config.decorator.decrypt.1"));
	decoratorConfig.getDecryptDecorators().put(DecoratorConfig.DECRYPT_AES, this.config.getProperty("crypto.config.decorator.decrypt.2"));
    }

    private void loadMathConfig(final Properties config) {
        if (mathConfig == null) {
            mathConfig = new MathConfig();
        }
        mathConfig.setFractions(Integer.parseInt(config.getProperty("crypto.config.math.fractions", "2")));
    }

    public String getConfiguration(String key) {
        return (this.config.getProperty(key) == null) ? "" : this.config.getProperty(key).trim();
    }

    /**
     * @return the mathConfig
     */
    public MathConfig getMathConfig() {
        return mathConfig;
    }

    /**
     * @param mathConfig the mathConfig to set
     */
    public void setMathConfig(MathConfig mathConfig) {
        this.mathConfig = mathConfig;
    }

    /**
     * @return the decoratorConfig
     */
    public DecoratorConfig getDecoratorConfig() {
        return decoratorConfig;
    }

    /**
     * @param decoratorConfig the decoratorConfig to set
     */
    public void setDecoratorConfig(DecoratorConfig decoratorConfig) {
        this.decoratorConfig = decoratorConfig;
    }

    /**
     * @return the aesConfig
     */
    public AESConfig getAesConfig() {
        return aesConfig;
    }

    /**
     * @param aesConfig the aesConfig to set
     */
    public void setAesConfig(AESConfig aesConfig) {
        this.aesConfig = aesConfig;
    }

    /**
     * @return the heConfig
     */
    public HEConfig getHeConfig() {
        return heConfig;
    }

    /**
     * @param heConfig the heConfig to set
     */
    public void setHeConfig(HEConfig heConfig) {
        this.heConfig = heConfig;
    }

    /**
     * @return the rsaConfig
     */
    public RSAConfig getRsaConfig() {
        return rsaConfig;
    }

    /**
     * @param rsaConfig the rsaConfig to set
     */
    public void setRsaConfig(RSAConfig rsaConfig) {
        this.rsaConfig = rsaConfig;
    }

}
