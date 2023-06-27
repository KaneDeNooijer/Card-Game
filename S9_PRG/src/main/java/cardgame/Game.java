package cardgame;

public class Game {
	 
	private int score;
	private Card currentCard;
	private Card nextCard;
	private Deck deck = new Deck();
	public enum HigherOrLower {HIGHER, LOWER};
	
	public boolean gameTurn(HigherOrLower higherOrLower) {
		
		if (!deck.areCardsLeft())
			return false;
		
		if (higherOrLower == HigherOrLower.HIGHER && nextCard.isHigherOrEqual(currentCard) || 
			higherOrLower == HigherOrLower.LOWER && !nextCard.isHigherOrEqual(currentCard)) {
			currentCard = deck.getNextCard();
			nextCard = deck.getNextCard();
			score++;
			return true;
		}
		
		currentCard = deck.getNextCard();
		nextCard = deck.getNextCard();
		if (score > 0)
			score--;
		return true;
	}
	
	public void setup() {
		currentCard = deck.getNextCard();
		nextCard = deck.getNextCard();
	}
	
	public int getScore() {
		return score;
	}
	
	public Card getCurrentCard() {
		return currentCard;
	}
	
	public Card getNextCard() {
		return nextCard;
	}
	
}
