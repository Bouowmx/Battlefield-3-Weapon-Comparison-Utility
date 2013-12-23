package Battlefield3WeaponComparison;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

public class SHA256 {
	public static String hash(String filename) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		FileInputStream fis = new FileInputStream(filename);
		byte[] fileBytes = new byte[(int) new File(filename).length()];
		int length;
		while ((length = fis.read(fileBytes)) != -1) {md.update(fileBytes, 0, length);}
		byte[] raw = md.digest();
		BigInteger bi = new BigInteger(1, raw);
		return bi.toString(16);
	}
}
