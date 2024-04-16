package pass.gen;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Password {
	private int length;
	private boolean bLowCase, bUpCase, bNumbers, bSymbols;
	private int[] rUpCase = { 65, 90 }, rLowCase = { 97, 122 },
			rNumbers = { 48, 57 }, rSymbols = { 33, 47 };

	public Password() {
		super();
	}

	public String generatePassword() {
		String out = "";
		List<int[]> rangeMatrix = new ArrayList<int[]>();
		if (bUpCase)
			rangeMatrix.add(rUpCase);
		if (bLowCase)
			rangeMatrix.add(rLowCase);
		if (bNumbers)
			rangeMatrix.add(rNumbers);
		if (bSymbols)
			rangeMatrix.add(rSymbols);
		SecureRandom sr = new SecureRandom();
		for (int i = 0; i < length; i++) {
			int typeRnd = sr.nextInt(0, rangeMatrix.size());
			int lowRange = rangeMatrix.get(typeRnd)[0];
			int upperRange = rangeMatrix.get(typeRnd)[1];
			out += (char) sr.nextInt(lowRange, upperRange + 1);
		}
		return out;
	}

	public void setbLowCase(boolean bLowCase) {
		this.bLowCase = bLowCase;
	}

	public void setbUpCase(boolean bUpCase) {
		this.bUpCase = bUpCase;
	}

	public void setbNumbers(boolean bNumbers) {
		this.bNumbers = bNumbers;
	}

	public void setbSymbols(boolean bSymbols) {
		this.bSymbols = bSymbols;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isCharSelected() {
		return this.bLowCase || this.bNumbers || this.bSymbols || this.bUpCase;
	}

}
