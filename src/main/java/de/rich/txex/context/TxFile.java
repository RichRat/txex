package de.rich.txex.context;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import de.rich.txex.exec.Line;

public class TxFile {

	List<String> past = new ArrayList<>();
	List<String> future;
	
	List<String> ret = new ArrayList<>();
	
	public TxFile(Path path) throws IOException {
		future = Files.readAllLines(path, StandardCharsets.UTF_8);
	}
	
	public String run() {
		
		String ret = "";
		Line line = new Line(this);
		while (!future.isEmpty()) {
			
			String runTxt = future.remove(0);
			ret = line.run(runTxt, past, future);
			past.add(runTxt);
		}
		
		
		return ret;
	}

	public int getLineNumber() {
		// TODO Auto-generated method stub
		return -2;
	}

	public void ret(String value) {
		ret.add(value);
		
	}
	
}
