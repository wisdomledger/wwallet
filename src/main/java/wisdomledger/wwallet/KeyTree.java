package wisdomledger.wwallet;

public class KeyTree {

	Key key;
	KeyTree child;
	KeyTree brother;

	public KeyTree(Key key, KeyTree child, KeyTree brother) {
		super();
		this.key = key;
		this.child = child;
		this.brother = brother;
	}

	int height(KeyTree kt) {

		int m, max = 0;
		if (kt.child == null) {
			return 0;
		} else if (kt.brother == null) {
			return 1;
		} else {
			KeyTree p = kt.child;
			while (p != null) {
				m = height(p);
				if (m > max) {
					max = m;
				}
				p = p.brother;
			}
			return max + 1;
		}
	}
}
