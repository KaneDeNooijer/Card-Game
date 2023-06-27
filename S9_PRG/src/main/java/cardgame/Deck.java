package cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards = new ArrayList<>();
	
	public Deck() {
		for (Suit s : Suit.values()) {
			for (Value v : Value.values()) {
				Card card = new Card(s, v, "images/cards/" + s + v + ".png");
				cards.add(card);
			}
		}
		
		Collections.shuffle(cards);
	}
	
	public Card getNextCard() {
		cards.remove(0);
		return cards.get(0);
	}
	
	public boolean areCardsLeft() {
		return cards.size() > 2;
	}
	
}
