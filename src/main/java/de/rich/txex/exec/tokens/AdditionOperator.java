package de.rich.txex.exec.tokens;

import java.util.Objects;

import de.rich.txex.exec.TxException;

public class AdditionOperator extends Operator {

	public static final int prio = 100;
	
	public AdditionOperator() {
		super("+", prio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String operate(Value a, Value b) throws TxException {
		if (a == null || b == null)
			throw new TxException("Invalid number of operands!");
		
		//also allow for float operations
		if (a.isNum() && b.isNum()) {
			return Objects.toString(a.asNum() + b.asNum());
		}
		else
			return a.value + b.value;
	}

}
