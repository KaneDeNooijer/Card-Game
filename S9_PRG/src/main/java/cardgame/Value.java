package cardgame;

public enum Value {
	
	twee(2),
	drie(3),
	vier(4),
	vijf(5),
	zes(6),
	zeven(7),
	acht(8),
	negen(9),
	tien(10),
	boer(11),
	koningin(12),
	koning(13),
	aas(14);

	private int numericalValue;
	
	private Value(int numericalValue) {
		this.numericalValue = numericalValue;
	}
	
	public int getNumericalValue() {
		return numericalValue;
	}
	
}
