package de.rich.txex.exec;

import java.util.ArrayList;
import java.util.List;

import de.rich.txex.context.TxFile;
import de.rich.txex.exec.tokens.AdditionOperator;
import de.rich.txex.exec.tokens.Keyword;
import de.rich.txex.exec.tokens.Token;
import de.rich.txex.exec.tokens.Value;

public class Line {
	
	private TxFile context;

	public Line(TxFile context) {
		this.context = context;

	}

	public String run(String line, List<String> past, List<String> future) {
		List<Token> tokens = tokenize(line);
		
		boolean isRet = false;
		boolean isSet = false;
		
		if (tokens.get(0).name == "") {
			isRet = true;
			tokens.remove(0);
		}
		
		while (tokens.size() > 1)
			runHighestPrioOp(tokens);
		
		
		if (isRet)
			context.ret(tokens.get(0).value);
		
		return "";
	}
	
	private void runHighestPrioOp(List<Token> tokens) {
		int maxPrio = 0;
		for (int i = 0; i < tokens.size(); i++) {
			
		}
	}

	private List<Token> tokenize(String line) {
		//for now no indentation
		List<Token> ret = new ArrayList<>();
		String[] splitl = line.replaceAll(" +", " ").split(" ");
		
		for (int i = 0; i < splitl.length; i++) {
			String sub = splitl[i];
			
			if (sub.equals("="))
				ret.add(new Keyword(i == 0 ? "=ret" : "=set"));
			else if (sub.matches("+"))
				ret.add(new AdditionOperator());
			else
				ret.add(new Value(sub));
		}
		
		// merge values that were part of strings with spaces (todo " and ' deliniated strings)
		for (int i = 1; i < ret.size(); i++) {
			if (ret.get(i - 1).isValue && ret.get(i).isValue) {
				ret.get(i - 1).value += ret.get(i).value;
				ret.remove(i); 
				i--;
			}
		}
		
		
		return null;
		
	}
}
