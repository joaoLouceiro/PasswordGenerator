package pass.gen;

public class Password {
	private int length;
	private boolean bLowCase, bUpCase, bNumbers, bSymbols;
	private int[] rUpCase = { 65, 90 }, rLowCase = { 97, 122 },
			rNumbers = { 48, 57 }, rSymbols = { 33, 47 };
	private String passOut;

	public Password() {
		super();
	}

	public String generatePassword() {
		return passOut;
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
