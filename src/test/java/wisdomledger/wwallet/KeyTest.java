package wisdomledger.wwallet;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.spongycastle.math.ec.ECPoint;

import junit.framework.TestCase;

public class KeyTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testKey() {

		SecureRandom random = new SecureRandom();
		int bits = 128;
		byte[] seed = getSeed(random, bits);

		Key key = new Key(seed);

		BigInteger k = key.getk();
		ECPoint point = key.getK();

		String x = point.getXCoord().toBigInteger().toString(16);
		String y = point.getYCoord().toBigInteger().toString(16);

		System.out.println("Private Key: " + k);
		System.out.println("Public Key: " + "(" + x + "," + y + ")");

	}

	/*
	 * public void testCreateHmacSha512Digest() { fail("Not yet implemented"); }
	 * 
	 * public void testHmacSha512() { fail("Not yet implemented"); }
	 * 
	 * public void testKToK() { fail("Not yet implemented"); }
	 * 
	 * public void testHmac_sha512() { fail("Not yet implemented"); }
	 */

	byte[] getSeed(SecureRandom random, int bits) {

		byte[] seed = new byte[bits / 8];
		random.nextBytes(seed);
		return seed;
	}

}
