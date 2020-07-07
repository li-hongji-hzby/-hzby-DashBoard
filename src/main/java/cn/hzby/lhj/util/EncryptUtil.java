package cn.hzby.lhj.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

/**
 * @author lhj
 */
public class EncryptUtil {
	/***
	* 利用Apache的工具类实现SHA-256加密
	* @param str 加密后的报文
	* @return
	*/
	public static String getSha256Str(String str){
	 MessageDigest messageDigest;
	 String encdeStr = "";
	 try {
	  messageDigest = MessageDigest.getInstance("SHA-256");
	  byte[] hash = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
	  encdeStr = Hex.encodeHexString(hash);
	 } catch (NoSuchAlgorithmException e) {
	  e.printStackTrace();
	 }
        return encdeStr;
	}
}
