package main;

public class Password {
	private int length;
	private boolean bLowCase, bUpCase, bNumbers, bSymbols;
	private String value;
	
	public Password() {
		super();
	}

	public Password(int length, boolean bLowCase, boolean bUpCase,
			boolean bNumbers, boolean bSymbols) {
		super();
		this.length = length;
		this.bLowCase = bLowCase;
		this.bUpCase = bUpCase;
		this.bNumbers = bNumbers;
		this.bSymbols = bSymbols;
	}
	
	public boolean isCharSelected() {
		return this.bLowCase || this.bNumbers || this.bSymbols || this.bUpCase;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isbLowCase() {
		return bLowCase;
	}

	public void setbLowCase(boolean bLowCase) {
		this.bLowCase = bLowCase;
	}

	public boolean isbUpCase() {
		return bUpCase;
	}

	public void setbUpCase(boolean bUpCase) {
		this.bUpCase = bUpCase;
	}

	public boolean isbNumbers() {
		return bNumbers;
	}

	public void setbNumbers(boolean bNumbers) {
		this.bNumbers = bNumbers;
	}

	public boolean isbSymbols() {
		return bSymbols;
	}

	public void setbSymbols(boolean bSymbols) {
		this.bSymbols = bSymbols;
	}



}
