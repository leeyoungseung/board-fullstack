package com.board.back.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 암호화 ↔ 복호화 유틸 클래스
 * @author leeyoungseung
 *
 */
public class EncryptUtil {

	private EncryptUtil() {}
	
	public static EncryptUtil getInstance() {
		return EncryptUtilHolder.INSTANCE;
	}
	
	private static class EncryptUtilHolder {
		private static final EncryptUtil INSTANCE = new EncryptUtil();
	}
	
	/**
	 * 바이트 배열을 HEX 문자열로 변환한다.
	 */
	protected String byteToHexString(byte[] data) {
		StringBuilder sb = new StringBuilder();
		for(byte b : data) {
			sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
	
	/**
	 * Encrypt to MD5 
	 * @throws NoSuchAlgorithmException 
	 */
	public String encryptMD5(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(text.getBytes());
		return byteToHexString(md.digest());
	}
	
	/**
	 * Encrypt to SHA256
	 * @throws NoSuchAlgorithmException 
	 */
	public String encryptSHA256(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(text.getBytes());
		return byteToHexString(md.digest());
	}
	
	/**
	 * Encrypt to SHA512
	 * @throws NoSuchAlgorithmException 
	 */
	public String encryptSHA512(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(text.getBytes());
		return String.format("%0128x", new BigInteger(1, md.digest()));
	}
	
	
	
	
}
