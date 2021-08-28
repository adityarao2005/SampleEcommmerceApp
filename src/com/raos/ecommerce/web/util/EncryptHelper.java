package com.raos.ecommerce.web.util;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncryptHelper {
	
	public static String encrypt(String str) {
		Encoder encoder = Base64.getEncoder().withoutPadding();
		return encoder.encodeToString(str.getBytes());
	}
	
	public static String decrypt(String str) {
		Decoder decoder = Base64.getDecoder();
		return new String(decoder.decode(str));
	}
}
