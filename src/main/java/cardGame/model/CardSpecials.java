package cardGame.model;

public enum CardSpecials {
	
	ACE('A', 1), JACK('J', 11), QUEEN('Q', 12), KING('K', 13);
	
	private char code;
	private int codeValue;
	
	private CardSpecials(char code, int codeValue) {
		this.code = code;
		this.codeValue = codeValue;
	}
		
	public static char getCode(int codeValue) {
		for (CardSpecials c : CardSpecials.values()) {
			if (codeValue == c.codeValue) {
				return c.code;
			}
		}
		return ' ';
	}	
}
