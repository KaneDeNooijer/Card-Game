package cardgame;

public class Card {
	
	private Suit suit;
	private Value value;
	private String url;
	
	public Card(Suit suit, Value value, String url) {
		this.suit = suit;
		this.value = value;
		this.url = url;
	}
	
	public boolean isHigherOrEqual(Card c) {
		return value.getNumericalValue() > c.value.getNumericalValue() || value.getNumericalValue() == c.value.getNumericalValue();
	}
	
	@Override
	public String toString() {
		return suit + " " + value;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
