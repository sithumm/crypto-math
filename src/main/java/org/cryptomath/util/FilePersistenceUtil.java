package org.cryptomath.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FilePersistenceUtil {
		
	public synchronized void writeFile (byte [] content, String filePath) throws IOException {
		OutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			out.write(content);

		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	public byte[] readFile(String path) throws Exception {		
		/**
		 * Get the payload
		 */
		File payloadFile = new File(path);
		if(!payloadFile.isFile()) {
			throw new Exception("Unknown IV reference");
		}
		byte[] iv = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(payloadFile);
			iv = new byte[16];
			fis.read(iv);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fis.close();
		}
			
		return iv;
	}
}
