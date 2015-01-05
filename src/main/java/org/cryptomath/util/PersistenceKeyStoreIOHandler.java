package org.cryptomath.util;

import java.io.File;
import java.security.KeyStoreException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

public class PersistenceKeyStoreIOHandler {

    private static DB db;
    private static HTreeMap<String, Object> keystoreMap;
    private static PersistenceKeyStoreIOHandler instance;
    private final static Logger logger = Logger
	    .getLogger(PersistenceKeyStoreIOHandler.class.getName());
    public final static String KEY_STORE_NAME = "keystore";
    public final static String KEY_STORE_MAP = "keystore.map";
    public final static String KEY_STORE_PATH = System.getProperty("user.home") + "/";
    private final Map<String, byte[]> ivs = new HashMap<String, byte[]>();

    private PersistenceKeyStoreIOHandler() throws KeyStoreException {
	if (db == null) {
	    db = DBMaker.newFileDB(new File(KEY_STORE_PATH + KEY_STORE_NAME))
		    .closeOnJvmShutdown().make();
	}
	keystoreMap = db.createHashMap(KEY_STORE_MAP).makeOrGet();
    }

    public static PersistenceKeyStoreIOHandler getInstance() {
	synchronized (PersistenceKeyStoreIOHandler.class) {
	    if (instance == null) {
		try {
		    instance = new PersistenceKeyStoreIOHandler();
		    logger.info(MessageFormat.format("{0}:Instantiated.",
			    PersistenceKeyStoreIOHandler.class.getName()));
		} catch (KeyStoreException e) {
		    logger.log(Level.SEVERE, MessageFormat.format(
			    "{0}" + e.getMessage(),
			    PersistenceKeyStoreIOHandler.class.getName()), e);
		}
	    }
	    return instance;
	}
    }

    /*
     * private HTreeMap<String, Object> loadKeyStore() { return keystoreMap; }
     */
    public void storeKey(String alias, Object key) {
	keystoreMap.put(alias, key);
	db.commit();
    }

    public Object getKey(String alias) {
	return keystoreMap.get(alias);
    }

    public void removeKeys(List<String> aliasList) {
	for (String alias : aliasList) {
	    keystoreMap.remove(alias);
	}
	db.commit();
    }

    public void removeKey(String alias) {
	keystoreMap.remove(alias);
	db.commit();
    }

    public void clear() {
	keystoreMap.clear();
	db.commit();
    }

    public int getKeyStoreSize() {
	return keystoreMap.size();
    }

    public void storeIV(byte[] iv, String key) throws Exception {
	ivs.put(key, iv);
	new FilePersistenceUtil().writeFile(iv, KEY_STORE_PATH + key);
    }

    public byte[] getIV(String key) throws Exception {
	if (ivs.containsKey(key)) {
	    return ivs.get(key);
	}
	return new FilePersistenceUtil().readFile(KEY_STORE_PATH + key);
    }

    @Override
    @SuppressWarnings("FinalizeDeclaration")
    protected void finalize() throws Throwable {
	db.close();
	super.finalize();
    }
}
