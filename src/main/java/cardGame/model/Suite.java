package cardGame.model;

public enum Suite {

	SPADE("spade"), CLUB("club"), DIAMOND("diamond"), HEART("heart");
	
	private String code;

	private Suite(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}

}
