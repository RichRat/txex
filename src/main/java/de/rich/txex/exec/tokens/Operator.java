package de.rich.txex.exec.tokens;

import de.rich.txex.exec.TxException;

public abstract class Operator extends Token {

	public enum OpType {
		UNARY,
		BINARY,
		TERNARY
	}
	
	public Operator(String name, int prio) {
		super(name, prio);
		// TODO Auto-generated constructor stub
	}

	public String operate(Value a) throws TxException { throw new TxException("Unsupported Operation"); }
	
	public String operate(Value a, Value b) throws TxException { throw new TxException("Unsupported Operation"); }
	
	public String operate(Value a, Value b, Value c) throws TxException { throw new TxException("Unsupported Operation"); }

}
