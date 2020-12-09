package com.analogics.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * 
 * @author achyuth kanth pamuru
 * 
 */
public class EncAndDecLogic {

	Cipher ecipher;
	Cipher dcipher;
	// 8-byte Salt
	byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
			(byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03 };
	// Iteration count
	int iterationCount = 19;

	/**
	 * 
	 * @param secretKey
	 *            Key used to encrypt data
	 * @param plainText
	 *            Text input to be encrypted
	 * @return Returns encrypted text
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchPaddingException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws InvalidKeyException 
	 * @throws UnsupportedEncodingException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * 
	 */
	public String encrypt( String plainText) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException{
		// Key generation for enc and desc
		String secretKey="analogics";
		KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt,
				iterationCount);
		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES")
				.generateSecret(keySpec);
		// Prepare the parameter to the ciphers
		AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt,
				iterationCount);

		// Enc process
		ecipher = Cipher.getInstance(key.getAlgorithm());
		ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
		String charSet = "UTF-8";
		byte[] in = plainText.getBytes(charSet);
		byte[] out = ecipher.doFinal(in);
		String encStr = new sun.misc.BASE64Encoder().encode(out);
		return encStr;
	}

	/**
	 * @param secretKey
	 *            Key used to decrypt data
	 * @param encryptedText
	 *            encrypted text input to decrypt
	 * @return Returns plain text after decryption
	 */
	public String decrypt(String encryptedText)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, IOException {
		// Key generation for enc and desc
		String secretKey="analogics";
		KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt,
				iterationCount);
		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES")
				.generateSecret(keySpec);
		// Prepare the parameter to the ciphers
		AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt,
				iterationCount);
		// Decryption process; same key will be used for decr
		dcipher = Cipher.getInstance(key.getAlgorithm());
		dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
		byte[] enc = new sun.misc.BASE64Decoder().decodeBuffer(encryptedText);
		byte[] utf8 = dcipher.doFinal(enc);
		String charSet = "UTF-8";
		String plainStr = new String(utf8, charSet);
		return plainStr;
	}

	public static void main(String[] args) {
		EncAndDecLogic e = new EncAndDecLogic();
		try{
//			http://b.aamurautzsms.com/websms/sendsms.aspx?userid=analogics&password=password&sender=ANALOG&mobileno=9966588075&msg=test
			String str=e.encrypt("india@123");
			System.out.println("enc :: "+str);
			str=e.decrypt("WXHdw0oYGgmELGfaE8fzgA==");
			System.out.println("dec :: "+str);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}