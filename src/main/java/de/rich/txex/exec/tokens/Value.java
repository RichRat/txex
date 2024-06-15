package de.rich.txex.exec.tokens;

public class Value extends Token {

	public Value(String value) {
		super("val", value);
	}

	public boolean isNum() {

		//TODO analyse input in onstructor and set state bools
		return false;
	}

	public int asNum() {
		// TODO Auto-generated method stub
		return 0;
	}
}
