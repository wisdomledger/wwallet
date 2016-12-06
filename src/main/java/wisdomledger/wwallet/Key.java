package wisdomledger.wwallet;

import java.util.Arrays;

public class Key {

	byte[] k;
	byte[] K;
	byte[] chainCode;

	public Key(byte[] seed) {
		super();
		byte[] i = hmac_sha512(seed);
		k = Arrays.copyOfRange(i, 0, 32);
		K = Arrays.copyOfRange(i, 32, 64);
	}

	//k to K
	byte[] kToK(byte[] k) {
		return null;
	}
	
	byte[] hmac_sha512(byte[] seed){
		return null;
	}
}
