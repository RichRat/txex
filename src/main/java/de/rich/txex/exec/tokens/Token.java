package de.rich.txex.exec.tokens;

import de.rich.txex.exec.TxException;

public abstract class Token {
	
	public boolean isValue = false;
	public String name;
	public String value;
	public int priority = -1;
	
	public Token(String name) {
		this.name = name;
	}
	
	public Token(String name, int prio) {
		this.name = name;
	}
	
	public Token(String name, String value) {
		this.name = name;
		this.value = value;
		this.isValue = true;
	}
}