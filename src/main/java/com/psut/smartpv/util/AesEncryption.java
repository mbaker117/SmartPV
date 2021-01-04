/*
 * @author MohammedBaker & Abd-Alqader Okasha
 */
package com.psut.smartpv.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * The Class AesEncryption.
 */
public class AesEncryption {
	
	/** The secret key. */
	private static SecretKeySpec secretKey;
	
	/** The key. */
	private static byte[] key;
	
	/** The secret. */
	private static String secret = "jackie";
	
	/**
	 * Instantiates a new aes encryption.
	 */
	private AesEncryption() {}

	/**
	 * Sets the key.
	 *
	 * @param myKey the new key
	 */
	public static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Encrypt.
	 *
	 * @param strToEncrypt the str to encrypt
	 * @return the string
	 */
	public static String encrypt(String strToEncrypt) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	/**
	 * Decrypt.
	 *
	 * @param strToDecrypt the str to decrypt
	 * @return the string
	 */
	public static String decrypt(String strToDecrypt) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

}