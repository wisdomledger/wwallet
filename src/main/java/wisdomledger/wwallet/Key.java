package wisdomledger.wwallet;

public class Key {

	byte[] seed;
	byte[] k;
	byte[] K;
	byte[] chainCode;

	public Key(byte[] seed) {
		super();
		this.seed = seed;
	}

	//k to K
	byte[] kToK(byte[] k) {
		return null;
	}
}
