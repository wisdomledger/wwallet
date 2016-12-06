package wisdomledger.wwallet;

import java.math.BigInteger;
import java.util.Arrays;

import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.ec.CustomNamedCurves;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.FixedPointCombMultiplier;

public class Key {

	X9ECParameters CURVE_PARAMS = CustomNamedCurves.getByName("secp256k1");
	ECDomainParameters CURVE = new ECDomainParameters(CURVE_PARAMS.getCurve(),
			CURVE_PARAMS.getG(), CURVE_PARAMS.getN(), CURVE_PARAMS.getH());

	// byte[] k;

	BigInteger k;
	ECPoint K;
	byte[] chainCode;

	public Key(byte[] seed) {
		
		super();
		byte[] i = hmac_sha512(seed);
		k = new BigInteger(1, Arrays.copyOfRange(i, 0, 32));

		K = kToK(k);
		chainCode = Arrays.copyOfRange(i, 32, 64);

	}

	static HMac createHmacSha512Digest(byte[] key) {
		
		SHA512Digest digest = new SHA512Digest();
		HMac hMac = new HMac(digest);
		hMac.init(new KeyParameter(key));
		return hMac;
	}

	static byte[] hmacSha512(HMac hmacSha512, byte[] input) {
		
		hmacSha512.reset();
		hmacSha512.update(input, 0, input.length);
		byte[] out = new byte[64];
		hmacSha512.doFinal(out, 0);
		return out;
	}

	// k to K
	ECPoint kToK(BigInteger k) {

		ECPoint K = new FixedPointCombMultiplier().multiply(CURVE.getG(), k);
		return K;
	}

	byte[] hmac_sha512(byte[] seed) {

		return hmacSha512(createHmacSha512Digest("Bitcoin seed".getBytes()),
				seed);
	}

}
