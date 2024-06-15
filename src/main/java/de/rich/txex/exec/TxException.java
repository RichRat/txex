package de.rich.txex.exec;

import de.rich.txex.context.TxFile;

public class TxException extends Exception {
	//TODO create more exceptions with fitting names

	private static final long serialVersionUID = 5075447824078169362L;

	public TxException(String err, TxFile context) {
		super(err + "\nat line: " + 1 + context.getLineNumber());
	}
	
	public TxException(String err) {
		super(err);
	}
}
